package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;


    @RequestMapping(value = "/departamento", method = RequestMethod.GET)
    public String home(Model model) {

        List<DepartamentoEntity> departamentos = departamentoService.findAllDepartments();

        model.addAttribute("page", "departamento");
        model.addAttribute("departamentos", departamentos);
        return "departamento/departamento";
    }

    @RequestMapping(value = "/departamento/crearDepartamento", method = RequestMethod.GET)
    public String crearDepartment(Model model) {
        model.addAttribute("page", "departamento");
        model.addAttribute("departmento", new DepartamentoEntity());
        return "departamento/crearDepartamento";
    }

    @RequestMapping(value="departamento/crearDepartamento", method=RequestMethod.POST)
    public String guardarDepartment(DepartamentoEntity DepartamentoEntity) {
        departamentoService.saveDepartamento(DepartamentoEntity);
        return "redirect:/departamento/";
    }


}
