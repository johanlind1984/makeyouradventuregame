package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
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

//    @OneToMany
//    private List<Integer> exitsList;
//
//    @OneToOne
//    private List<Item> item;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="room_question_id")
//    private Question question;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="room_item_required_id")
//    private Item requiredItem;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="room_enemy_id")
//    private Enemy enemy;

    private boolean isSolved;

    public Room() {
    }
}
