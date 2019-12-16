package com.epam.vsharstuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public String getLogin(){
        return "login";
    }*/
}
