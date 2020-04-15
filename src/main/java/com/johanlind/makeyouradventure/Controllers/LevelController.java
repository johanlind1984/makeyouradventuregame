package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.*;
import com.johanlind.makeyouradventure.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping()
public class LevelController {
    @Autowired
    private ItemContainerRepository itemContainerRepository;
    @Autowired
    private EnemyRepository enemyRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AlternativesRepository alternativesRepository;
    @Autowired
    private RoomRepository repositoryRoom;
    @Autowired
    private ContainerIdentifierRepository containerIdentifierRepository;
    @Autowired
    private ItemKeyRepository itemKeyRepository;
    @Autowired
    private LevelRepository levelRepository;

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
        levelList = levelRepository.findAll();
        return "index";
    }

    @RequestMapping(value="/runtests")
    public String runTests() {
        itemKeyList = itemKeyRepository.findAll();
        enemyList = enemyRepository.findAll();
        storyList = storyRepository.findAll();
        questionList = questionRepository.findAll();
        alternativesList = alternativesRepository.findAll();
        itemContainerList = itemContainerRepository.findAll();
        containerIdentifierList = containerIdentifierRepository.findAll();
        roomList = repositoryRoom.findAll();
        levelList = levelRepository.findAll();


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
