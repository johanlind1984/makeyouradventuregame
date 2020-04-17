package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Level;
import com.johanlind.makeyouradventure.Entity.Room;
import com.johanlind.makeyouradventure.Entity.Story;
import com.johanlind.makeyouradventure.Repositories.LevelRepository;
import com.johanlind.makeyouradventure.Repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wizard")
public class WizardController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private LevelRepository levelRepository;

    @RequestMapping("start-wizard")
    public String startWizard(Model theModel) {
        theModel.addAttribute("level", new Level());
        return "create-level";
    }

    @RequestMapping("save-level")
    public String saveLevel(@ModelAttribute("level") Level level, Model theModel) {
        levelRepository.save(level);
        theModel.addAttribute("level", level);
        theModel.addAttribute("story", new Story());
        return "create-story";
    }

    @RequestMapping("/save-story")
    public String saveStory(@RequestParam(value = "levelid") int levelId, @ModelAttribute("story") Story story, Model theModel) {
        Level level = levelRepository.findById(levelId).orElse(null);
        level.setStory(story);
        levelRepository.save(level);
        theModel.addAttribute("level", new Level());
        theModel.addAttribute("room", new Room());
        return "create-room";
    }

}
