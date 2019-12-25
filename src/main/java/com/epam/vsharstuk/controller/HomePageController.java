package com.epam.vsharstuk.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class HomePageController {

    private Logger LOG = Logger.getLogger(HomePageController.class);

    @RequestMapping(method= RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String getHome() {

        return "home";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
