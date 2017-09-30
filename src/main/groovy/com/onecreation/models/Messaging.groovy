package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Messaging {
    private Long timestamp
    private Map<String, String> message

    Long getTimestamp() {
        return timestamp
    }

    void setTimestamp(long timestamp) {
        this.timestamp = timestamp
    }

    Map<String, String> getMessage() {
        return message
    }

    void setMessage(Map<String, String> message) {
        this.message = message
    }


    @Override
    public String toString() {
        return "Messaging{" +
                "timestamp=" + timestamp +
                ", message=" + message +
                '}';
    }
}
