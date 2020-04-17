package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="level")
public class Level {

    @Id()
    @Column(name="id_level")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int levelId;

    @Column(name="level_name")
    String levelName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="level_story_id")
    private Story story;

    @ManyToMany(mappedBy = "levelList")
    private List<Room> roomList;

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public Level() {

    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }


}
