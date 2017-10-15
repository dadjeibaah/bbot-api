package com.onecreation.services

import com.onecreation.enums.EntityTypeEnum
import com.onecreation.models.ConversationContext
import com.onecreation.models.Customer
import com.onecreation.models.Messaging
import com.onecreation.models.NLPEntity
import com.onecreation.models.Preferences
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ConversationGeneratorServiceImpl implements ConversationGeneratorService {

    private ConversationCtxtService conversationCtxtService
    private CustomerService customerService
    private HashMap<EntityTypeEnum, String> responses

    @Autowired
    ConversationGeneratorServiceImpl(
            ConversationCtxtService conversationCtxtService,
            CustomerService customerService
    ) {
        this.conversationCtxtService = conversationCtxtService
        this.customerService = customerService
        responses = new HashMap<>()
        responses.put(EntityTypeEnum.GREETINGS, "Sup' Bro")
        responses.put(EntityTypeEnum.LOCAL_SEARCH_QUERY, "Are you trying to search for something near you?")
        responses.put(EntityTypeEnum.LOCATION, "Are you trying to search for something near you?")
    }

    Map generateConversation(Messaging incomingMsg, NLPEntity likelyNLP) {
        String receiver = incomingMsg.recipient.id
        Customer potentialCustomer = customerService.findByFacebookId(receiver)
        if (!potentialCustomer && !conversationCtxtService.isConversationsAvailable(receiver)) {
           beginCustomerIntro(incomingMsg)
        } else if (!potentialCustomer && conversationCtxtService.isConversationsAvailable(receiver)) {
            continueCustomerIntro(incomingMsg)
        } else {
            String msg = "${responses.get(likelyNLP.type)}. I can help if you ask me a question."
            [receiver: receiver, message: msg]
        }
    }

    @Override
    Map beginCustomerIntro(Messaging incomingMsg) {
        String receiver = incomingMsg.recipient.id
        ConversationContext convo = new ConversationContext([
                "What is your favorite hairstyle?",
                "What number can I reach you at?",
        ])
        conversationCtxtService.saveConversation(receiver, convo)
        return [receiver: receiver,
         message : "Before we continue, I would like to get to know you. " + convo.currentQuestion.questionText]
    }


    Map continueCustomerIntro(Messaging incomingMsg) {
        String receiver = incomingMsg.recipient.id
        def midConvo = conversationCtxtService.find(receiver)
        midConvo.answerQuestion(incomingMsg.message.text)
        if (midConvo.numberAnswered == midConvo.questions.size()) {
            def newCustomer = new Customer(
                    UUID.randomUUID().toString(),
                    "User",
                    receiver,
                    (midConvo.questions.answerText as Preferences))
            customerService.save(newCustomer)
            conversationCtxtService.delete(receiver)
            [receiver: receiver, message: "Thanks!"]
        } else {
            conversationCtxtService.saveConversation(receiver, midConvo)
            [receiver: receiver, message: midConvo.currentQuestion.questionText]
        }

    }
}

