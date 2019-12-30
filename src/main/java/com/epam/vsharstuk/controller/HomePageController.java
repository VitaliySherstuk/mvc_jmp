package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.service.impl.UserDetailsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:home";
    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String getHome(@CookieValue("userName") String userName, Model model) {
        LOG.info("Get home page");
        if (userName != null) {
            model.addAttribute("userNameStatus", true);
            model.addAttribute("userName", userName);
        }
        return "home";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
