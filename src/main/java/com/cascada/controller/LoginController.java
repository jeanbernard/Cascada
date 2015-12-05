package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.UsuarioEntity;
import com.cascada.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Layout(value="login")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("usuario", new UsuarioEntity());
        modelAndView.addObject("errors", new ArrayList<String>());
        return modelAndView;
    }

    @Layout(value="login")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String login( UsuarioEntity usuarioEntity, HttpSession session , Model model) {

        if(!usuarioService.isCampoUsuarioValido(usuarioEntity)){
            ArrayList<String> errors = new ArrayList();
            errors.add("Favor, llenar campos requeridos");
            model.addAttribute("errors", errors);
            model.addAttribute("usuario", new UsuarioEntity());
            return "login";
        }

        HashMap result = usuarioService.loginUsuario(usuarioEntity);
        if(result.get("logged") != null) {
            session.setAttribute("nombreUsuario", usuarioEntity.getNombreUsuario());
            return "redirect:/home";
        }

        model.addAttribute("errors", (ArrayList<String>)result.get("errors"));
        model.addAttribute("usuario", new UsuarioEntity());

        return "login";

    }

    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public String logout(HttpSession session) {
        if(session != null){
            session.removeAttribute("nombreUsuario");
            session.invalidate();
        }
        return "redirect:/";

    }
}
