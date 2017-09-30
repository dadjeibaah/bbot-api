package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Message {
    private String mid
    private String text

    String getMid() {
        return mid
    }

    void setMid(String mid) {
        this.mid = mid
    }

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }


    @Override
    public String toString() {
        return "Message{" +
                "mid='" + mid + '\'' +
                ", text='" + text + '\'' +
                '}'
    }
}
