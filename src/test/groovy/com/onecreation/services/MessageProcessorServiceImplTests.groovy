package com.onecreation.services

import com.onecreation.models.Entry
import com.onecreation.models.Message
import com.onecreation.models.Messaging
import com.onecreation.models.Sender
import org.junit.Before
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

class MessageProcessorServiceImplTests {

    private MessageProcessorService messageProcessorService

    private Entry generateMockEntry() {
        Entry mockEntry = new Entry()
        Messaging messaging = new Messaging()
        messaging.sender = new Sender()
        messaging.sender.id = "123"
        Message message = new Message()
        message.setText("Hi There!")
        messaging.setMessage(message)
        mockEntry.setMessaging(Arrays.asList(messaging))
        mockEntry
    }

    @Before
    void setup() {
        messageProcessorService = new MessageProcessorServiceImpl()
    }

    @Test
    void returnTheUsersMessage() {
        Entry mockEntry = generateMockEntry()
        Messaging response = messageProcessorService.generateResponsesForEntries(mockEntry)
        assertThat(response.message.text).isEqualTo("Hi There!")
    }

    @Test
    void returnMessageShouldNotHaveNlpAndMidProperty() {
        Entry mockEntry = generateMockEntry()
        Messaging response = messageProcessorService.generateResponsesForEntries(mockEntry)
        assertThat(response.message.mid).isNull()
        assertThat(response.message.nlp).isNull()
    }


}
