package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.IngresoEntity;
import com.cascada.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Controller
@Layout(value="layouts/default")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model) {
        List<IngresoEntity> ingresos = ingresoService.findAllIngresos();
        model.addAttribute("page", "ingreso");
        model.addAttribute("ingresos", ingresos);
        return "ingreso/ingreso";
    }

    @RequestMapping(value="/ingreso/crearIngreso", method = RequestMethod.GET)
    public String crearIngreso(Model model, IngresoEntity ingreso) {
        model.addAttribute("page", "ingreso");
        model.addAttribute("ingreso", ingreso);
        return "ingreso/crearIngreso";
    }

    @RequestMapping(value="ingreso/crearIngreso", method=RequestMethod.POST)
    public String guardarIngreso(@Valid @ModelAttribute("ingreso") IngresoEntity ingreso, BindingResult bindingResult) {

        List<IngresoEntity> allIngresos = ingresoService.findAllIngresos();

        for(IngresoEntity ingresoDB : allIngresos) {
            if(ingresoDB.getNombre().equals(ingreso.getNombre())) {
                return "ingreso/crearIngreso";
            }
        }

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.ingreso.nombre", null, null);
            return "ingreso/crearIngreso";
        }

        ingresoService.saveIngreso(ingreso);
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
    public String updateIngreso(@Valid @ModelAttribute("ingreso") IngresoEntity ingreso, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.ingreso.nombre", null, null);
            return "ingreso/editarIngreso";
        }

        ingresoService.updateIngreso(ingreso);
        return "redirect:/ingreso/";
    }

}
