package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Story;
import com.johanlind.makeyouradventure.Repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @RequestMapping("/save-story")
    public ModelAndView saveStory(@ModelAttribute("story") Story story) {
        storyRepository.save(story);

        return new ModelAndView("redirect:/logged-in/");
    }
}
