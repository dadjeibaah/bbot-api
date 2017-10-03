package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Messaging {
    private Long timestamp
    private Message message
    private Sender sender
    private Recipient recipient

    Message getMessage() {
        return message
    }

    void setMessage(Message message) {
        this.message = message
    }

    Long getTimestamp() {
        return timestamp
    }

    void setTimestamp(long timestamp) {
        this.timestamp = timestamp
    }

    Sender getSender() {
        return sender
    }

    void setSender(Sender sender) {
        this.sender = sender
    }

    @Override
    public String toString() {
        return "Messaging{" +
                "timestamp=" + timestamp +
                ", message=" + message +
                ", sender="  + sender +
                '}'
    }
}
