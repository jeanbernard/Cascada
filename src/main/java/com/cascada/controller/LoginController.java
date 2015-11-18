package com.cascada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

}
