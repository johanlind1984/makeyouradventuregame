package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.*;
import com.johanlind.makeyouradventure.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping()
public class ControllerLevel {
    @Autowired
    private RepositoryItemContainer repositoryItemContainer;
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
    @Autowired
    private RepositoryContainerIdentifier repositoryContainerIdentifier;
    @Autowired
    private RepositoryItemKey repositoryItemKey;
    @Autowired
    private RepositoryLevel repositoryLevel;

    private List<ItemContainer> itemContainerList;
    private List<Enemy> enemyList;
    private List<Story> storyList;
    private List<Question> questionList;
    private List<Alternatives> alternativesList;
    private List<Room> roomList;
    private List<ContainerIdentifier> containerIdentifierList;
    private List<ItemKey> itemKeyList;
    private List<Level> levelList;

    @RequestMapping(value="/instantiatelevels")
    public String instantiate() {
        levelList = repositoryLevel.findAll();
        return "index";
    }

    @RequestMapping(value="/runtests")
    public String runTests() {
        itemKeyList = repositoryItemKey.findAll();
        enemyList = repositoryEnemy.findAll();
        storyList = repositoryStory.findAll();
        questionList = repositoryQuestion.findAll();
        alternativesList = repositoryAlternatives.findAll();
        itemContainerList = repositoryItemContainer.findAll();
        containerIdentifierList = repositoryContainerIdentifier.findAll();
        roomList = repositoryRoom.findAll();
        levelList = repositoryLevel.findAll();


        for (Level level : levelList) {
            System.out.println("\n\n\n");
            System.out.println("LEVELTEST: ");
            System.out.println("Level id: " + level.getLevelId() + " Level description: " + level.getLevelName());

            System.out.println("ROOMTEST: ");
            for (Room room : level.getRoomList()) {
                System.out.println("Room " + room.getRoomId() + " Description: " + room.getDescription());
                System.out.println("ITEMTEST: ");
                for (ContainerIdentifier container : room.getContainerIdentifierList()) {
                    System.out.println("Identifier ID: " + container.getContainerIdentifierId());
                    System.out.println("ItemContainer: " + container.getItemContainer().getItemName());
                    System.out.println("Required Key: " + container.getItemContainer().getRequiredItemKey().getItemKeyName());
                    System.out.println("Required Description: " + container.getItemContainer().getRequiredItemDescription());
                    for (ItemKey item : container.getListItems()) {
                        System.out.println("Containing item: " + item.getItemKeyName());
                    }
                    System.out.println("");
                }
                System.out.println("");
                System.out.println("QUESTIONTEST: ");
                for (Question question :room.getQuestionSet()) {
                    System.out.println("QUESTION: ");
                    System.out.println(question.getQuestionDescription());
                    System.out.println("ALTERNATIVES: ");
                    for (Alternatives alternatives : question.getAlternativesSet()) {
                        System.out.println(alternatives.getText());
                        System.out.println("CORRECT: " + alternatives.getCorrect());
                    }
                    System.out.println("");
                }

                System.out.println("");
                System.out.println("ENEMYTEST: ");
                for (Enemy enemy : room.getEnemyList()) {
                    System.out.println("Enemy: " + enemy.getNameEnemy());
                }

                System.out.println("=======END OF ROOM " + room.getRoomId() + "======");
                System.out.println("\n");
            }
            System.out.println("====END OF LEVEL====");

        }

        return "start-create-adventure";
    }
}
