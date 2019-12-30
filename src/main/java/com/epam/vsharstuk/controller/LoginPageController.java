package com.epam.vsharstuk.controller;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    private Logger LOG = Logger.getLogger(SettingsController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){

        if (error != null){
            model.addAttribute("wrongLogin", true);
            model.addAttribute("messageWrongLogin", "This user does not exist");
        }

        if (logout != null) {
            model.addAttribute("logout", true);
            model.addAttribute("message", "You've been logged out successfully.");
        }
        return "login";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }

}
