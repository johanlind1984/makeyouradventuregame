package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.*;
import com.johanlind.makeyouradventure.Repositories.*;
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
    @Autowired
    private RepositoryQuestion repositoryQuestion;
    @Autowired
    private RepositoryAlternatives repositoryAlternatives;
    @Autowired
    private RepositoryRoom repositoryRoom;

    private List<Item> itemList;
    private List<Enemy> enemyList;
    private List<Story> storyList;
    private List<Question> questionList;
    private List<Alternatives> alternativesList;
    private List<Room> roomList;

    @RequestMapping(name="/")
    public String startCreateAdventure () {
        itemList = repositoryItem.findAll();
        enemyList = repositoryEnemy.findAll();
        storyList = repositoryStory.findAll();
        questionList = repositoryQuestion.findAll();
        alternativesList = repositoryAlternatives.findAll();
        roomList = repositoryRoom.findAll();


        for (Room room : roomList) {
            System.out.println(room.getDescription());
            System.out.println("items in room " + room.getRoomId() + ": ");
            for (Item item : room.getRoomItems()) {
                System.out.println(item.getItemName());
                System.out.println (item.getItemName() + " contains: " + item.getContainingItemId());
            }
        }

        return "start-create-adventure";
    }
}