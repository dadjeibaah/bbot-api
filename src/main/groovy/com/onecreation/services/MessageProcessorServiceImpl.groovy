package com.onecreation.services

import com.onecreation.models.Entry
import com.onecreation.models.Messaging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageProcessorServiceImpl implements MessageProcessorService {

    private CustomerService customerService


    @Autowired
    MessageProcessorServiceImpl(CustomerService customerService) {
        this.customerService = customerService
    }

    @Override
    Messaging generateResponsesForEntries(Entry entry) {
         entry.messaging.first()
    }
}
