package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.domain.PuestoEntity;
import com.cascada.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jeanbernard on 11/28/15.
 */

@Controller
@Layout(value="layouts/default")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;


    @RequestMapping(value="/puesto", method = RequestMethod.GET)
    public String puesto(Model model) {
        model.addAttribute("page", "puesto");
        return "puesto/puesto";
    }

    @RequestMapping(value="/puesto/crearPuesto", method = RequestMethod.GET)
    public String crearPuesto(Model model) {
        model.addAttribute("page", "puesto");
        model.addAttribute("puesto", new PuestoEntity());
        return "puesto/crearPuesto";
    }

    @RequestMapping(value="puesto/crearPuesto", method=RequestMethod.POST)
    public String guardarPuesto(PuestoEntity puestoEntity) {
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();
        departamentoEntity.setDepartamentoId(1L);
        puestoEntity.setDepartamentoEntity(departamentoEntity);
        puestoService.savePuesto(puestoEntity);
        return "redirect:/puesto/";
    }


}
