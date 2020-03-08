package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
public class Item {
    // Annotations Done

    @Id
    @Column(name="id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_description")
    private String description;

    @Column(name="item_required_description")
    private String requiredItemDescription;

    @Column(name="item_containing_description")
    private String containingItemDescription;

    // Fix mapping one to one Item
    @Column(name="item_containing_item")
    private int containingItemId;

    // Fix mapping one to one Item
    @Column(name="item_required_item")
    private int requiredItemId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "room_item",
            joinColumns = { @JoinColumn(name = "id_item") },
            inverseJoinColumns = { @JoinColumn(name = "room_id") }
    )
    private List<Room> roomList = new ArrayList<>();

    public Item() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredItemDescription() {
        return requiredItemDescription;
    }

    public void setRequiredItemDescription(String requiredItemDescription) {
        this.requiredItemDescription = requiredItemDescription;
    }

    public String getContainingItemDescription() {
        return containingItemDescription;
    }

    public void setContainingItemDescription(String containingItemDescription) {
        this.containingItemDescription = containingItemDescription;
    }

    public int getContainingItemId() {
        return containingItemId;
    }

    public void setContainingItemId(int containingItemId) {
        this.containingItemId = containingItemId;
    }

    public int getRequiredItemId() {
        return requiredItemId;
    }

    public void setRequiredItemId(int requiredItemId) {
        this.requiredItemId = requiredItemId;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
