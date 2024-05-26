package com.vti.quizzes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "scores")
public class Score {

    @Id
    private Long id;
    private Long quizId;
    private List<Object> answers;
    private Long userId;
    private Date createdAt;
    private boolean deleted;

    public Score() {
        this.createdAt = new Date();
        this.deleted = false;
    }


    public Score(Long quizId, List<Object> answers, Long userId) {
        this.quizId = quizId;
        this.answers = answers;
        this.userId = userId;
        this.createdAt = new Date();
        this.deleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<Object> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Object> answers) {
        this.answers = answers;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
