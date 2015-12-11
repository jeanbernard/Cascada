package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.domain.PuestoEntity;
import com.cascada.service.DepartamentoService;
import com.cascada.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jeanbernard on 11/28/15.
 */

@Controller
@Layout(value="layouts/default")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value="/puesto", method = RequestMethod.GET)
    public String puesto(Model model) {
        List<PuestoEntity> puestos = puestoService.findAllPuestos();
        model.addAttribute("page", "puesto");
        model.addAttribute("puestos", puestos);
        return "puesto/puesto";
    }

    @RequestMapping(value="/puesto/crearPuesto", method = RequestMethod.GET)
    public String crearPuesto(Model model, PuestoEntity puesto) {
        model.addAttribute("page", "puesto");
        model.addAttribute("puesto", puesto);
        model.addAttribute("departamentos", departamentoService.findAllDepartments());
        return "puesto/crearPuesto";
    }

    @RequestMapping(value="puesto/crearPuesto", method=RequestMethod.POST)
    public String guardarPuesto(@Valid @ModelAttribute ("puesto") PuestoEntity puesto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.deduccion.nombre", null, null);
            return "puesto/crearPuesto";
        }

        puestoService.savePuesto(puesto);
        return "redirect:/puesto/";
    }

    @RequestMapping(value="puesto/edit/{puestoId}", method=RequestMethod.GET)
    public String updatePuesto(Model model, @PathVariable(value = "puestoId") Long puestoId) {

        PuestoEntity puesto = puestoService.findPuesto(puestoId);

        model.addAttribute("page", "puesto");
        model.addAttribute("puesto", puesto);
        model.addAttribute("departamentos", departamentoService.findAllDepartments());

        return "/puesto/editarPuesto";
    }

    @RequestMapping(value="puesto/editarPuesto", method=RequestMethod.POST)
    public String updatepuesto(@Valid @ModelAttribute ("puesto") PuestoEntity puesto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.puesto.nombre", null, null);
            return "/puesto/editarPuesto";
        }


        puestoService.updatePuesto(puesto);
        return "redirect:/puesto/";
    }

}
