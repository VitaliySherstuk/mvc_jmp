package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.User;
import com.epam.vsharstuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "name") String name,
                               @RequestParam(value = "password") String password) {

        userService.createUser(name, password);
        return "login";
    }
}
