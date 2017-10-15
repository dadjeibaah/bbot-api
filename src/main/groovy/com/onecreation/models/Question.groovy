package com.onecreation.models

class Question implements Serializable {
    String questionText
    String answerText

    Question(String questionText, String answerText) {
        this.questionText = questionText
        this.answerText = answerText
    }
}
