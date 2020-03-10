package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL,
//              fetch = FetchType.LAZY, optional = false)
//    private Question question;
//
//    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL,
//              fetch = FetchType.LAZY, optional = false)
//    private Item requiredItem;
//
//    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL,
//              fetch = FetchType.LAZY, optional = false)
//    private Enemy enemy;
//
//    private boolean isSolved;
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
}
