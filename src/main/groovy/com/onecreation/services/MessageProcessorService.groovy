package com.onecreation.services

import com.onecreation.models.Entry
import com.onecreation.models.Messaging

interface MessageProcessorService {
    Messaging generateResponsesForEntries(Entry entry)
}