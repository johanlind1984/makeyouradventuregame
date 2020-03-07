package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Enemy;
import com.johanlind.makeyouradventure.Entity.Item;
import com.johanlind.makeyouradventure.Entity.Story;
import com.johanlind.makeyouradventure.Repositories.RepositoryEnemy;
import com.johanlind.makeyouradventure.Repositories.RepositoryItem;
import com.johanlind.makeyouradventure.Repositories.RepositoryStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerLevel {
    @Autowired
    private RepositoryItem repositoryItem;
    @Autowired
    private RepositoryEnemy repositoryEnemy;
    @Autowired
    private RepositoryStory repositoryStory;

    private List<Item> itemList;
    private List<Enemy> enemyList;
    private List<Story> storyList;

    @RequestMapping(name="/")
    public String startCreateAdventure () {
        itemList = repositoryItem.findAll();
        enemyList = repositoryEnemy.findAll();
        storyList = repositoryStory.findAll();

        return "start-create-adventure";
    }
}