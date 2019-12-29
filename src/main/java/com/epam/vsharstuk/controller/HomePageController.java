package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.service.impl.UserDetailsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomePageController {

    private Logger LOG = Logger.getLogger(HomePageController.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(method= RequestMethod.GET)
    public String getHomePage(HttpServletResponse response) {
        LOG.info("Get home page");
        String userName = userDetailsService.getUserDetails().getUsername();
        response.addCookie(new Cookie("userName", userName));
        return "home";
    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String getHome() {
        LOG.info("Get home page");
        return "home";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
