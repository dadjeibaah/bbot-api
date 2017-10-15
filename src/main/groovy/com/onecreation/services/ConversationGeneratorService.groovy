package com.onecreation.services

import com.onecreation.models.Customer
import com.onecreation.models.Messaging
import com.onecreation.models.NLPEntity

interface ConversationGeneratorService {
    Map generateConversation(Messaging incomingMsg, NLPEntity likelyNLP)
    Map beginCustomerIntro(Messaging incomingMsg)
    Map continueCustomerIntro(Messaging incomingMsg)
}
