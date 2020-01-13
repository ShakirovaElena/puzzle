package ru.shakirova.puzzle.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    private int id;
    private String text;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private DifficultyLevel difficultyLevel;
    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
