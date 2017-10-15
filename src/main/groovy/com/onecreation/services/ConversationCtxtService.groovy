package com.onecreation.services

import com.onecreation.models.ConversationContext

interface ConversationCtxtService {
    void saveConversation(String id, ConversationContext ctxt)
    ConversationContext find(String id)
    void delete(String id)
    boolean isConversationsAvailable(String id)

}