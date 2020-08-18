package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="room")
public class Room {

    @Id
    @Column(name="room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Column(name="room_description")
    private String description;

    @Column(name="room_imagepath")
    private String imagePath;

    @ManyToMany(mappedBy = "roomList")
    private List<ContainerIdentifier> containerIdentifierList = new ArrayList<>();

    @ManyToMany(mappedBy = "roomSetQuestions")
    private Set<Question> questionSet;

    @ManyToMany(mappedBy = "roomSetEnemies")
    private List<Enemy> enemyList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "story_room",
            joinColumns = { @JoinColumn(name = "story_room_room_id") },
            inverseJoinColumns = { @JoinColumn(name = "story_room_story_id") }
    )
    private List<Story> storyList;

    // CONSIDER IF THIS MAPPING NEEDS A UNIQUE CLASS, LIKE "LOCK" WHICH NEEDS TO BE UNLOCKED TO ENTER THE ROOM.
    // COULD ALSO BE VERY POSSIBLE TO USE A ItemContainer AS A LOCK.
//    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL,
//              fetch = FetchType.LAZY, optional = false)
//    private Item requiredItem;
//
//
// private boolean isSolved;
//
//    private List<Integer> exitsList;

    public Room() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<ContainerIdentifier> getContainerIdentifierList() {
        return containerIdentifierList;
    }

    public void setContainerIdentifierList(List<ContainerIdentifier> containerIdentifierList) {
        this.containerIdentifierList = containerIdentifierList;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }
}
