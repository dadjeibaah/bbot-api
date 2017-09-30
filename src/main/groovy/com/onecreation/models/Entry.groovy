package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Entry {
    private String id
    private Long time
    private List<Messaging> messaging

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    long getTime() {
        return time
    }

    void setTime(long time) {
        this.time = time
    }

    List<Messaging> getMessaging() {
        return messaging
    }

    void setMessaging(List<Messaging> messaging) {
        this.messaging = messaging
    }


    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", messaging=" + messaging +
                '}';
    }
}
