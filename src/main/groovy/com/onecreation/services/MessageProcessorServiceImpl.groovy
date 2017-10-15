package com.onecreation.services

import com.onecreation.enums.EntityTypeEnum
import com.onecreation.models.Entry
import com.onecreation.models.Messaging
import com.onecreation.models.NLPEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageProcessorServiceImpl implements MessageProcessorService {

    private CustomerService customerService
    private ConversationGeneratorService conversationGeneratorService
    private HashMap<EntityTypeEnum, String> responses


    @Autowired
    MessageProcessorServiceImpl(
            CustomerService customerService,
            ConversationGeneratorService conversationGeneratorService) {
        this.customerService = customerService
        this.conversationGeneratorService = conversationGeneratorService
    }

    @Override
    Messaging generateResponsesForEntries(Entry entry) {
        Messaging incomingMsg = entry.messaging.first()
        NLPEntity likelyNLP = incomingMsg.message.nlp.max { n -> n.confidence }
        Map bbotResponse = conversationGeneratorService.generateConversation(incomingMsg, likelyNLP)
         return new Messaging((bbotResponse?.receiver as String), (bbotResponse?.message as String))
    }
}
