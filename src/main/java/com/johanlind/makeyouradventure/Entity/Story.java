package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="story")
public class Story {

    @Id
    @Column(name="id_story")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStory;

    @Column(name="story_name")
    private String name;

    @Column(name="story_beginning")
    private String beginning;

    @Column(name="story_end")
    private String end;

    @Column(name="story_die")
    private String die;

    @ManyToMany(mappedBy = "storyList")
    private List<Room> roomList;

    public Story() {
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDie() {
        return die;
    }

    public void setDie(String die) {
        this.die = die;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
