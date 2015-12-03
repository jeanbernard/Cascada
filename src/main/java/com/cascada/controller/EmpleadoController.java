package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.EmpleadoEntity;
import com.cascada.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;


    @RequestMapping(value = "/empleado", method = RequestMethod.GET)
    public String home(Model model) {

        List<EmpleadoEntity> empleados = empleadoService.findAllEmpleados();

        model.addAttribute("page", "empleado");
        model.addAttribute("empleados", empleados);
        return "empleado/empleado";
    }

    @RequestMapping(value = "/empleado/crearEmpleado", method = RequestMethod.GET)
    public String crearDepartment(Model model) {
        model.addAttribute("page", "empleado");
        model.addAttribute("departmento", new EmpleadoEntity());
        return "empleado/crearEmpleado";
    }

    @RequestMapping(value="empleado/crearEmpleado", method=RequestMethod.POST)
    public String guardarDepartment(EmpleadoEntity EmpleadoEntity) {
        empleadoService.saveEmpleado(EmpleadoEntity);
        return "redirect:/empleado/";
    }

    @RequestMapping(value="empleado/edit/{empleadoId}", method=RequestMethod.GET)
    public String updateEmpleado(Model model, @PathVariable(value = "empleadoId") Long empleadoId) {

        EmpleadoEntity dept = empleadoService.findEmpleado(empleadoId);

        model.addAttribute("page", "empleado");
        model.addAttribute("dept", dept);

        return "/empleado/editarEmpleado";
    }

    @RequestMapping(value="empleado/editarEmpleado", method=RequestMethod.POST)
    public String updateEmpleado(@ModelAttribute EmpleadoEntity dept) {
        empleadoService.updateEmpleado(dept);
        return "redirect:/empleado/";
    }


}
