package com.vti.quizzes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "questions")
public class Question {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "question_sequence";
    private ArrayList<String> answers;
    private String correctAnswer;
    private String questionName;

    public Question() {
    }

//    public Question(Long id, ArrayList<String> answers, String correctAnswer, String questionName) {
//        this.id = id;
//        this.answers = answers;
//        this.correctAnswer = correctAnswer;
//        this.questionName = questionName;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
}
