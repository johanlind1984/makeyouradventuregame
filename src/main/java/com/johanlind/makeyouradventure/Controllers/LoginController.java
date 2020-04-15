package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Story;
import com.johanlind.makeyouradventure.Entity.User;
import com.johanlind.makeyouradventure.Repositories.UserAuthorityRepository;
import com.johanlind.makeyouradventure.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/logged-in")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/")
    public String startPage(Model model, Principal principal) {

        User user = userRepository.findByUsername(principal.getName());
        System.out.println(user.getUsername());
        int userMenuChoice = 0;
        model.addAttribute("user", user);
        model.addAttribute("userMenuChoice", userMenuChoice);
        return "index";
    }

    @RequestMapping(value="/menuChoice")
    public String directUserStarMenu(
            @RequestParam(value = "userMenuChoice", required = false) Integer userMenuChoice, Model theModel) {

        System.out.println("Choice: " + userMenuChoice);

        switch (userMenuChoice) {
            case 1:
                theModel.addAttribute("story", new Story());
                return "create-existing-adventure";
            case 2:
                theModel.addAttribute("story", new Story());
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
