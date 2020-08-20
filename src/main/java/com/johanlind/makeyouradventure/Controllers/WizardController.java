package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Room;
import com.johanlind.makeyouradventure.Entity.Story;
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
}
