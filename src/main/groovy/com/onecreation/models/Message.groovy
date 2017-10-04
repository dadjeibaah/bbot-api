package com.onecreation.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonUnwrapped
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class Message {
    private String mid
    private String text
    @JsonDeserialize(using = NLPDeserializer.class)
    private List<NLPEntity> nlp


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

    List<NLPEntity> getNlp() {
        return nlp
    }


    @Override
     String toString() {
        return "Message{" +
                "mid='" + mid + '\'' +
                ", text='" + text + '\'' +
                ", nlp=" + nlp +
                '}'
    }
}
