package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Enemy;
import com.johanlind.makeyouradventure.Entity.Room;
import com.johanlind.makeyouradventure.Entity.Story;
import com.johanlind.makeyouradventure.Repositories.EnemyRepository;
import com.johanlind.makeyouradventure.Repositories.RoomRepository;
import com.johanlind.makeyouradventure.Repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/wizard")
public class WizardController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EnemyRepository enemyRepository;

    @RequestMapping("start-wizard")
    public ModelAndView startWizard(Model theModel) {
        return new ModelAndView("redirect:/wizard/create-story");
    }

    @RequestMapping("/create-story")
    public String createStory(Model theModel)  {
        theModel.addAttribute("story", new Story());
        return "create-story";
    }

    @RequestMapping("/save-story")
    public String saveLevel(@ModelAttribute("story") Story story, Model theModel) {
        // Bör jag istället ladda modellen med story som innehåller rum eller bör jag bara skicka ett rum till modellen?
        Story storyFromDatabase = storyRepository.save(story);
        Room room = new Room();
        room.setStoryList(new ArrayList<>());
        room.getStoryList().add(storyFromDatabase);
        theModel.addAttribute(room);
        return "create-room";
    }

    @RequestMapping("/create-enemy")
    public String createEnemy(Model theModel) {
        theModel.addAttribute("enemy", new Enemy());
        return "create-enemy";
    }

    @RequestMapping("/save-enemy")
    public String saveEnemy(@ModelAttribute("enemy") Enemy enemy, Model theModel) {
        enemyRepository.save(enemy);
        // whats next?
        return "";
    }

}
