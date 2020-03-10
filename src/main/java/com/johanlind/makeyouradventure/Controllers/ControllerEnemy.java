package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Enemy;
import com.johanlind.makeyouradventure.Repositories.RepositoryEnemy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/enemy")
public class ControllerEnemy {

    @Autowired
    private RepositoryEnemy repositoryEnemy;
    private List<Enemy> enemyList;
    private Enemy enemy;

    // listAllEnemies, getEnemy, saveEnemy,

    @RequestMapping(value="/instantiateenemies")
    public String instantiate() {
        enemyList = repositoryEnemy.findAll();
        return "index";
    }
}
