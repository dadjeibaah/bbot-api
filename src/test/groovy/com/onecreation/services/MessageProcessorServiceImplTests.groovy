package com.onecreation.services

import com.onecreation.models.Entry
import com.onecreation.models.Message
import com.onecreation.models.MessageResponse
import com.onecreation.models.Messaging
import org.junit.Before
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

class MessageProcessorServiceImplTests {

    private MessageProcessorService messageProcessorService

    @Before
    void setup() {
        messageProcessorService = new MessageProcessorServiceImpl()
    }

    @Test
    void returnTheUsersMessage() {
        Entry mockEntry = new Entry()
        Messaging messaging = new Messaging()
        Message message = new Message()
        message.setText("Hi There!")
        messaging.setMessage(message)
        mockEntry.setMessaging(Arrays.asList(messaging))
        MessageResponse response = messageProcessorService.generateResponsesForEntries(mockEntry)
        assertThat(response.message.text).isEqualTo("Hi There!")
    }
}
