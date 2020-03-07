package com.johanlind.makeyouradventure.Entity;

import javax.persistence.*;

@Entity
@Table(name="enemy")
public class Enemy {

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

    public Enemy() {
    }
}
