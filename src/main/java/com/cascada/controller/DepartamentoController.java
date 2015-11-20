package com.cascada.controller;

import com.cascada.annotations.Layout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class DepartamentoController {

    @RequestMapping(value = "/departamento", method = RequestMethod.GET)
    public String home(Model model) {
        return "departamento";
    }

}
