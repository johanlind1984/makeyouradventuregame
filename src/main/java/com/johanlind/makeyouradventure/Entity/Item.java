package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_containing_item")
    private Item containingItem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_required_item")
    private Item requiredItem;

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

    public Item getContainingItem() {
        return containingItem;
    }

    public void setContainingItem(Item containingItem) {
        this.containingItem = containingItem;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }
}
