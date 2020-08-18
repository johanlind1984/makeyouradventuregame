package com.johanlind.makeyouradventure.Controllers;

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
    public ModelAndView startWizard(Model theModel) {
        return new ModelAndView("redirect:/wizard/create-level");
    }

    @RequestMapping("/create-level")
    public String createStory(Model theModel)  {
        theModel.addAttribute("story", new Story());
        return "create-level";
    }

    @RequestMapping("/save-level")
    public String saveLevel(@ModelAttribute("story") Story story, Model theModel) {
//        story.setLevel(story.getLevel());
//        levelRepository.save(story.getLevel());
        storyRepository.save(story);
        // add object to model and redirect to the next step, f.ex. rooms
        return "create-room";
    }

    @RequestMapping("/save-story")
    public String saveStory(@RequestParam(value = "levelid") int levelId, @ModelAttribute("story") Story story, Model theModel) {
//        Level level = levelRepository.findById(levelId).orElse(null);
//        level.setStory(story);
//        levelRepository.save(level);
//        theModel.addAttribute("level", new Level());
//        theModel.addAttribute("room", new Room());
        return "create-room";
    }

}
