package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="question")
public class Question {

    @Id
    @Column(name="id_question")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionID;

    @Column(name="question_imagepath")
    private String imagePath;

    @Column(name="question_description")
    private String questionDescription;

//    @OneToMany
//    private Map<String, Boolean> alternativesAndAnswer;

    public Question() {
    }
}
