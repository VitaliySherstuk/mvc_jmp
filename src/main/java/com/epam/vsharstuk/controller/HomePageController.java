package com.epam.vsharstuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController {

    @RequestMapping(method= RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String getHome() {
        return "home";
    }

}
