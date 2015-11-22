package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.Departamento;
import com.cascada.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DepartamentoRepository departamentoRepository;


    @RequestMapping(value = "/departamento", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("page", "departamento");
        return "departamento/departamento";
    }

    @RequestMapping(value = "/departamento/crearDepartamento", method = RequestMethod.GET)
    public String crearDepartment(Model model) {
        model.addAttribute("page", "departamento");
        model.addAttribute("departmento", new Departamento());
        return "departamento/crearDepartamento";
    }

    @RequestMapping(value="departamento/crearDepartamento", method=RequestMethod.POST)
    public String guardarDepartment(Departamento departamento) {
        System.out.println(departamento.getNombre());
        System.out.println(departamento.getDescripcion());
        //departamentoRepository.saveDepartment();
        return "redirect:/departamento/";
    }


}
