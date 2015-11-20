package com.cascada.controller;

import com.cascada.annotations.Layout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class DepartamentoController {

    @RequestMapping(value = "/departamento", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("page", "departamento");
        return "departamento/departamento";
    }

    @RequestMapping(value = "/departamento/crear", method = RequestMethod.GET)
    public String crearDepartamento(Model model) {
        model.addAttribute("page", "departamento");
        return "departamento/crearDepartamento";
    }


}
