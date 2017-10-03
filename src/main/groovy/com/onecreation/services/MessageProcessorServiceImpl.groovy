package com.onecreation.services

import com.onecreation.models.Entry
import com.onecreation.models.Message
import com.onecreation.models.Messaging
import com.onecreation.models.Recipient
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
    Messaging generateResponsesForEntries(Entry entry){
        Messaging response = entry.messaging.first()
        Messaging newReply = new Messaging()
        newReply.message = new Message()
        Recipient recipient = new Recipient()
        String receiver = response.sender.id
        recipient.setId(receiver)
        newReply.setRecipient(recipient)
        newReply.message.text = response.message.text
        newReply
    }
}
