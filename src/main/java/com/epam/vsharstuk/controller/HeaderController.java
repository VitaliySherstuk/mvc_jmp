package com.epam.vsharstuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/header")
public class HeaderController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHeader(@CookieValue("userName") String userName, Model model) {
        if (userName != null) {
            model.addAttribute("userNameStatus", true);
            model.addAttribute("userName", userName);
        }
            return "header";
    }
}
