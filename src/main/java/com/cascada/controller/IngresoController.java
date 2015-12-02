package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.IngresoEntity;
import com.cascada.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Controller
@Layout(value="layouts/default")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @RequestMapping(value="/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model) {
        List<IngresoEntity> ingresos = ingresoService.findAllIngresos();
        model.addAttribute("page", "ingreso");
        model.addAttribute("ingresos", ingresos);
        return "ingreso/ingreso";
    }

    @RequestMapping(value="/ingreso/crearIngreso", method = RequestMethod.GET)
    public String crearIngreso(Model model) {
        model.addAttribute("page", "ingreso");
        model.addAttribute("ingreso", new IngresoEntity());
        return "ingreso/crearIngreso";
    }

    @RequestMapping(value="ingreso/crearIngreso", method=RequestMethod.POST)
    public String guardarIngreso(IngresoEntity ingresoEntity) {
        ingresoService.saveIngreso(ingresoEntity);
        return "redirect:/ingreso/";
    }

    @RequestMapping(value="ingreso/edit/{ingresoId}", method=RequestMethod.GET)
    public String updateIngreso(Model model, @PathVariable(value = "ingresoId") Long ingresoId) {

        IngresoEntity ingreso = ingresoService.findIngreso(ingresoId);

        model.addAttribute("page", "ingreso");
        model.addAttribute("ingreso", ingreso);

        return "/ingreso/editarIngreso";
    }

    @RequestMapping(value="ingreso/editarIngreso", method=RequestMethod.POST)
    public String updateIngreso(@ModelAttribute IngresoEntity ingreso) {
        ingresoService.updateIngreso(ingreso);
        return "redirect:/ingreso/";
    }

}