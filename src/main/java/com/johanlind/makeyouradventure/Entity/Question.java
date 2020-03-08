package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="question")
public class Question {
    // Annotations Done

    @Id
    @Column(name="id_question")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionID;

    @Column(name="question_imagepath")
    private String imagePath;

    @Column(name="question_description")
    private String questionDescription;

     @OneToMany(
             mappedBy = "question",
             cascade = CascadeType.ALL,
             orphanRemoval = true
     )
     private Set<Alternatives> alternativesSet = new HashSet<>();

    public Question() {
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Set<Alternatives> getAlternativesSet() {
        return alternativesSet;
    }

    public void setAlternativesSet(Set<Alternatives> alternativesSet) {
        this.alternativesSet = alternativesSet;
    }
}
