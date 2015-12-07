package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.*;
import com.cascada.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private EmpleadoIngresoService empleadoIngresoService;



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
        model.addAttribute("empleadoIngreso", new EmpleadoIngresoEntity());
        model.addAttribute("test", new IngresoEntity());
        model.addAttribute("puestos", puestoService.findAllPuestos());
        model.addAttribute("ingresos",ingresoService.findAllIngresos());
        return "empleado/crearEmpleado";
    }

    @RequestMapping(value="/empleado/crearEmpleado", method=RequestMethod.POST)
    public String guardarEmpleado(EmpleadoEntity empleadoEntity, EmpleadoIngresoEntity empleadoIngresoEntity, IngresoEntity ingresoEntity) {
        EmpleadoEntity empleadoCreado = empleadoService.saveEmpleado(empleadoEntity);
        EmpleadoEntity empleado = empleadoService.findEmpleado(empleadoCreado.getEmpleadoId());
        empleadoIngresoService.saveEmpleadoIngreso(empleadoIngresoEntity, empleado.getEmpleadoId(), ingresoEntity);
        return "redirect:/empleado/";
    }

    /* JSON EN CREAR  */

    @RequestMapping(value="empleado/crearEmpleado/json/departamentos", method = RequestMethod.GET)
    public @ResponseBody List<DepartamentoEntity> findAllDepartmentsCrear() {
        return departamentoService.findAllDepartments();
    }

    @RequestMapping(value="empleado/crearEmpleado/json/puestos", method = RequestMethod.GET)
    public @ResponseBody List<PuestoEntity> filterPuestosCrear(@RequestParam Long departamentoId) {
        return puestoService.findAllPuestosByDepartmento(departamentoId);
    }

    @RequestMapping(value="empleado/crearEmpleado/json/ingresos", method = RequestMethod.GET)
    public @ResponseBody List<IngresoEntity> filterIngresos() {
        List<IngresoEntity> ingresos =  ingresoService.findAllIngresos();
        return ingresos;
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

    @RequestMapping(value="empleado/edit/json/puestos", method = RequestMethod.GET)
    public @ResponseBody List<PuestoEntity> filterPuestos(@RequestParam Long departamentoId) {
        return puestoService.findAllPuestosByDepartmento(departamentoId);
    }

}
