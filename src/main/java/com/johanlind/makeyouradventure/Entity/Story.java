package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;

@Entity
@Table(name="story")
public class Story {

    @Id
    @Column(name="id_story")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStory;

    @Column(name="story_beginning")
    private String beginning;

    @Column(name="story_end")
    private String end;

    @Column(name="story_die")
    private String die;

    public Story() {
    }
}
