package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Enemy;
import com.johanlind.makeyouradventure.Repositories.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/enemy")
public class EnemyController {

    @Autowired
    private EnemyRepository enemyRepository;
    private List<Enemy> enemyList;
    private Enemy enemy;

    // listAllEnemies, getEnemy, saveEnemy,

    @RequestMapping(value="/instantiateenemies")
    public String instantiate() {
        enemyList = enemyRepository.findAll();
        return "index";
    }
}
