package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationPageController {

    @Autowired
    private UserService userService;

    private Logger LOG = Logger.getLogger(RegistrationPageController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "name") String name,
                               @RequestParam(value = "password") String password,
                               HttpServletResponse response) {
        userService.createUser(name, password);
        response.addCookie(new Cookie("username", name));
        return "login";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
