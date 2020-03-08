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

    private List<Item> itemList;
    private List<Enemy> enemyList;
    private List<Story> storyList;
    private List<Question> questionList;
    private List<Alternatives> alternativesList;

    @RequestMapping(name="/")
    public String startCreateAdventure () {
        itemList = repositoryItem.findAll();
        enemyList = repositoryEnemy.findAll();
        storyList = repositoryStory.findAll();
        questionList = repositoryQuestion.findAll();
        alternativesList = repositoryAlternatives.findAll();

        for (Question question : questionList) {
            System.out.println("Question: " + question.getQuestionID());
            System.out.println(question.getQuestionDescription());

            for (Alternatives alternative : question.getAlternativesSet()) {
                System.out.println(alternative.getText() + "\n Is Correct: " + alternative.getCorrect());
            }

        }

        return "start-create-adventure";
    }
}