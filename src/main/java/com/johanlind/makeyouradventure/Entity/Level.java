package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="level")
public class Level {

    @Id()
    @Column(name="id_level")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int roomId;

    @Column(name="level_name")
    String levelName;

//    @ManyToMany(mappedBy = "level_room")
//    @JoinTable()
//    private Map<Integer, Room> roomList;

    public Level() {

    }
}
