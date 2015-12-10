package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.service.DepartamentoService;
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
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/departamento", method = RequestMethod.GET)
    public String home(Model model) {

        List<DepartamentoEntity> departamentos = departamentoService.findAllDepartments();

        model.addAttribute("page", "departamento");
        model.addAttribute("departamentos", departamentos);
        return "departamento/departamento";
    }

    @RequestMapping(value = "/departamento/crearDepartamento", method = RequestMethod.GET)
    public String crearDepartment(Model model, DepartamentoEntity departmento) {
        model.addAttribute("page", "departamento");
        model.addAttribute("departmento", departmento);
        return "departamento/crearDepartamento";
    }

    @RequestMapping(value="departamento/crearDepartamento", method=RequestMethod.POST)
    public String guardarDepartment(@Valid @ModelAttribute("departmento") DepartamentoEntity departmento, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.departmento.nombre", null, null);
            return "departamento/crearDepartamento";
        }

        departamentoService.saveDepartamento(departmento);
        return "redirect:/departamento/";
    }

    @RequestMapping(value="departamento/edit/{departamentoId}", method=RequestMethod.GET)
    public String updateDepartamento(Model model, @PathVariable(value = "departamentoId") Long departamentoId) {

        DepartamentoEntity departmento = departamentoService.findDepartment(departamentoId);

        model.addAttribute("page", "departamento");
        model.addAttribute("departmento", departmento);

        return "/departamento/editarDepartamento";
    }

    @RequestMapping(value="departamento/editarDepartamento", method=RequestMethod.POST)
    public String updateDepartamento(@Valid @ModelAttribute("departmento") DepartamentoEntity departmento, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.departmento.nombre", null, null);
            return "departamento/editarDepartamento";
        }

        departamentoService.updateDepartamento(departmento);
        return "redirect:/departamento/";
    }


}
