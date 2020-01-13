package ru.shakirova.puzzle.entity;

import javax.persistence.*;

@Entity
public class Statistics {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Question question;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
    private int elapsedTime;
    private int attemptsCount;
    private Boolean solved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }
}
