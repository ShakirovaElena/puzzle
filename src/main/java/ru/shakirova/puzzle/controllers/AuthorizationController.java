package ru.shakirova.puzzle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/registration")
    public String getRegistrationPage(){
        return "registration";
    }
}
