package com.johanlind.makeyouradventure.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerStart {

    @RequestMapping(value="/")
    public String startPage(Model model) {
        int userMenuChoice = 0;
        model.addAttribute("userMenuChoice", userMenuChoice);
        return "index";
    }

    @RequestMapping(value="/menuChoice")
    public String directUserStarMenu(
            @RequestParam(value = "userMenuChoice", required = false) Integer userMenuChoice, Model model) {

        System.out.println("Choice: " + userMenuChoice);

        switch (userMenuChoice) {
            case 1:
                return "create-existing-adventure";
            case 2:
                return "create-new-adventure";
            case 3:
                return "create-resources";
            case 4:
                return "browse-resources";
            default:
                return "something-went-wrong";
        }
    }
}
