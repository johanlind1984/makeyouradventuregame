package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="enemy")
public class Enemy {
    // Annotations Done

    @Id
    @Column(name="id_enemy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnemy;

    @Column(name="name_enemy")
    private String nameEnemy;

    @Column(name="image_enemy")
    private String imageEnemy;

    @Column(name="hp_enemy")
    private int hpEnemy;

    @Column(name="low_damage_enemy")
    private int enemyLowDamage;

    @Column(name="high_damage_enemy")
    private int enemyHighDamage;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "room_enemies",
            joinColumns = { @JoinColumn(name = "room_enemies_room_id") },
            inverseJoinColumns = { @JoinColumn(name = "room_enemies_enemy_id") }
    )
    private List<Room> roomSetEnemies;

    public Enemy() {
    }

    public int getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(int idEnemy) {
        this.idEnemy = idEnemy;
    }

    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public String getImageEnemy() {
        return imageEnemy;
    }

    public void setImageEnemy(String imageEnemy) {
        this.imageEnemy = imageEnemy;
    }

    public int getHpEnemy() {
        return hpEnemy;
    }

    public void setHpEnemy(int hpEnemy) {
        this.hpEnemy = hpEnemy;
    }

    public int getEnemyLowDamage() {
        return enemyLowDamage;
    }

    public void setEnemyLowDamage(int enemyLowDamage) {
        this.enemyLowDamage = enemyLowDamage;
    }

    public int getEnemyHighDamage() {
        return enemyHighDamage;
    }

    public void setEnemyHighDamage(int enemyHighDamage) {
        this.enemyHighDamage = enemyHighDamage;
    }

    public List<Room> getRoomListEnemies() {
        return roomSetEnemies;
    }

    public void setRoomListEnemies(List<Room> roomSetEnemies) {
        this.roomSetEnemies = roomSetEnemies;
    }
}
