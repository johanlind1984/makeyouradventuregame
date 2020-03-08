package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;

@Entity
@Table(name="question_alternatives")
public class Alternatives {
    // Annotations Done

    @Id()
    @Column(name="id_alternatives")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name="id_question_alternatives")
//    private int idQuestion;

    @Column(name="alternative_text")
    private String text;

    @Column(name="alternative_correct")
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name="id_question_alternatives", nullable=false)
    private Question question;

    public Alternatives() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

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

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

}
