package com.onecreation.models

class ConversationContext implements Serializable {
    LinkedList<Question> questions
    Integer numberAnswered
    Question currentQuestion

    ConversationContext(List<String> questionsText) {
        questions = questionsText.collect { q -> new Question(q, null)}
        currentQuestion = questions.head()
        numberAnswered = 0
    }

    void answerQuestion(String answer){
        currentQuestion.answerText = answer
        numberAnswered++
        if(numberAnswered != questions.size()){
            currentQuestion = questions.get(numberAnswered)
        }

    }
}
