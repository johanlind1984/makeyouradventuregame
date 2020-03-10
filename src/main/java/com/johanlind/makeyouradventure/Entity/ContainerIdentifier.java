package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="container_identifier")
public class ContainerIdentifier {

    @Id
    @Column(name = "id_containeer_identifier")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int containerIdentifierId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_type_id")
    private ItemContainer ItemContainer;

    @ManyToMany(mappedBy = "containerIdentifierList")
    private List<ItemKey> listItems;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "room_item",
            joinColumns = { @JoinColumn(name = "id_item") },
            inverseJoinColumns = { @JoinColumn(name = "room_id") }
    )
    private List<Room> roomList = new ArrayList<>();



    public ContainerIdentifier() {
    }

    public int getContainerIdentifierId() {
        return containerIdentifierId;
    }

    public void setContainerIdentifierId(int containerIdentifierId) {
        this.containerIdentifierId = containerIdentifierId;
    }

    public ItemContainer getItemContainer() {
        return ItemContainer;
    }

    public void setItemContainer(ItemContainer itemContainer) {
        ItemContainer = itemContainer;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<ItemKey> getListItems() {
        return listItems;
    }

    public void setListItems(List<ItemKey> listItems) {
        this.listItems = listItems;
    }
}
