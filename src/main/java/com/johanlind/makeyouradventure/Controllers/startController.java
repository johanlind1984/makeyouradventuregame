package com.johanlind.makeyouradventure.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class startController {

    @RequestMapping("/")
    public String startPage () {
        return "index";
    }
}
