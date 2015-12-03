package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.PuestoEntity;
import com.cascada.service.DepartamentoService;
import com.cascada.service.EmpleadoService;
import com.cascada.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private PuestoService puestoService;

    @Autowired
    private DepartamentoService departamentoService;


    @RequestMapping(value = "/empleado", method = RequestMethod.GET)
    public String consultarEmpleado(Model model) {

        List<EmpleadoEntity> empleados = empleadoService.findAllEmpleados();

        model.addAttribute("page", "empleado");
        model.addAttribute("empleados", empleados);
        return "empleado/empleado";
    }

    @RequestMapping(value = "/empleado/crearEmpleado", method = RequestMethod.GET)
    public String crearEmpleado(Model model) {
        model.addAttribute("page", "empleado");
        model.addAttribute("empleado", new EmpleadoEntity());
        model.addAttribute("puestos", puestoService.findAllPuestos());
        return "empleado/crearEmpleado";
    }

    @RequestMapping(value="empleado/crearEmpleado", method=RequestMethod.POST)
    public String guardarEmpleado(EmpleadoEntity empleadoEntity) {
        empleadoService.saveEmpleado(empleadoEntity);
        return "redirect:/empleado/";
    }

    @RequestMapping(value="empleado/edit/{empleadoId}", method=RequestMethod.GET)
    public String updateEmpleado(Model model, @PathVariable(value = "empleadoId") Long empleadoId) {

        EmpleadoEntity empleado = empleadoService.findEmpleado(empleadoId);

        model.addAttribute("page", "empleado");
        model.addAttribute("empleado", empleado);
        model.addAttribute("puestos", puestoService.findAllPuestos());

        return "/empleado/editarEmpleado";
    }

    @RequestMapping(value="empleado/editarEmpleado", method=RequestMethod.POST)
    public String updateEmpleado(@ModelAttribute EmpleadoEntity dept) {
        empleadoService.updateEmpleado(dept);
        return "redirect:/empleado/";
    }

    @RequestMapping(value="empleado/edit/json/departamentos", method = RequestMethod.GET)
    public @ResponseBody List<DepartamentoEntity> findAllDepartments() {
        return departamentoService.findAllDepartments();
    }

    @RequestMapping(value="empleado/edit/json/puestos/{departamentoId}", method = RequestMethod.GET)
    public @ResponseBody List<PuestoEntity> filterPuestos(Long departamentoId) {
        return puestoService.findAllPuestosByDepartmento(departamentoId);
    }


}
