package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item_container")
public class ItemContainer {
    // Annotations Done

    @Id
    @Column(name="id_itemcontainer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;

    @Column(name="itemcontainer_name")
    private String itemName;

    @Column(name="itemcontainer_description")
    private String description;

    @Column(name="itemcontainer_required_description")
    private String requiredItemDescription;

    @Column(name="itemcontainer_containing_description")
    private String descriptionOpenItemContainer;

    // Kommer behöva en jointable mellan keyItem och itemcontainer om ex. en kista skall kunna innehålal flera oliak items
    // @ManyToMany, då kommer en kista dels kunna hålla mer en endast ett iten, en kista kommer även kunna innehålla flera items.
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "itemContainer_containing_item")
//    private ItemContainer containingItemContainer;

    @OneToOne(mappedBy = "ItemContainer", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private ContainerIdentifier containerIdentifier;

    // Denna bör dock ha en one to one relationsip till itemKey, om det skulle vara many to many skulle prblemet kunna landa i
    // att en itemContainer kan låsas upp av flera olika keyItems.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemcontainer_required_keyitem")
    private ItemKey requiredItemKey;

    // Fix mapping one to one ItemKey - Denna skall likka i Item Keyu sedan, ovanstående skall @OneToOne skall ligga
    // kvar i denna klassen. KeyItem och ItemContainer skall ha samma förhållande som ContainerIdentifier och ItemContainer


    public ItemContainer() {
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

    public String getDescriptionOpenItemContainer() {
        return descriptionOpenItemContainer;
    }

    public void setDescriptionOpenItemContainer(String descriptionOpenItemContainer) {
        this.descriptionOpenItemContainer = descriptionOpenItemContainer;
    }

    public ContainerIdentifier getContainerIdentifier() {
        return containerIdentifier;
    }

    public void setContainerIdentifier(ContainerIdentifier containerIdentifier) {
        this.containerIdentifier = containerIdentifier;
    }

    public ItemKey getRequiredItemKey() {
        return requiredItemKey;
    }

    public void setRequiredItemKey(ItemKey requiredItemKey) {
        this.requiredItemKey = requiredItemKey;
    }
}
