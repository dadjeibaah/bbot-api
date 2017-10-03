package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonUnwrapped

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class Message {
    private String mid
    private String text
    private Map<String, Object> nlp


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

    Map<String, Object> getNlp() {
        return nlp
    }

    void setNlp(Map<String, Object> nlp) {
        this.nlp = nlp
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid='" + mid + '\'' +
                ", text='" + text + '\'' +
                ", nlp=" + nlp +
                '}'
    }
}
