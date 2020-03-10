package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item_key")
public class ItemKey {

    @Id
    @Column(name="id_itemkey")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemKey;

    @Column(name="itemkey_name")
    private String itemKeyName;

    @Column(name="itemkey_description")
    private String itemKeyDescription;

    @OneToOne(mappedBy = "requiredItemKey", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private ItemContainer requiredItemContainer;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "container_identifier_containing_item",
            joinColumns = { @JoinColumn(name = "containing_item") },
            inverseJoinColumns = { @JoinColumn(name = "idcontainer_identifier") }
    )
    private List<ContainerIdentifier> containerIdentifierList = new ArrayList<>();

    public ItemContainer getRequiredItemContainer() {
        return requiredItemContainer;
    }

    public void setRequiredItemContainer(ItemContainer requiredItemContainer) {
        this.requiredItemContainer = requiredItemContainer;
    }

    public ItemKey() {
    }

    public int getIdItemKey() {
        return idItemKey;
    }

    public void setIdItemKey(int idItemKey) {
        this.idItemKey = idItemKey;
    }

    public String getItemKeyName() {
        return itemKeyName;
    }

    public void setItemKeyName(String itemKeyName) {
        this.itemKeyName = itemKeyName;
    }

    public String getItemKeyDescription() {
        return itemKeyDescription;
    }

    public void setItemKeyDescription(String itemKeyDescription) {
        this.itemKeyDescription = itemKeyDescription;
    }
}
