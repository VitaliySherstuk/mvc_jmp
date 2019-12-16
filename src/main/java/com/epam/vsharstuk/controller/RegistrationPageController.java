package com.epam.vsharstuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistration() {
        return "registration";
    }
}
