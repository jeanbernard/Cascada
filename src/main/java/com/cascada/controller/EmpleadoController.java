package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.*;
import com.cascada.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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
    private DeduccionService deduccionService;

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

        ArrayList<EmpleadoIngresoEntity> ingreso = new ArrayList<EmpleadoIngresoEntity>();
        ArrayList<EmpleadoDeduccionEntity> deduccion = new ArrayList<EmpleadoDeduccionEntity>();

        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setEmpleadoIngreso(ingreso);
        empleado.setEmpleadoDeduccion(deduccion);

        List<IngresoEntity> ingresos = ingresoService.findAllIngresos();
        List<DeduccionEntity> deducciones = deduccionService.findAllDeducciones();

        for (IngresoEntity ingresoCreado : ingresos) {
            EmpleadoIngresoEntity empleadoIngreso = new EmpleadoIngresoEntity();
            empleadoIngreso.setIngresoId(ingresoCreado);
            empleadoIngreso.setEmpleadoId(empleado);
            empleado.getEmpleadoIngreso().add(empleadoIngreso);
        }

        for (DeduccionEntity deduccionCreado : deducciones) {
            EmpleadoDeduccionEntity empleadoDeduccion = new EmpleadoDeduccionEntity();
            empleadoDeduccion.setDeduccionId(deduccionCreado);
            empleadoDeduccion.setEmpleadoId(empleado);
            empleado.getEmpleadoDeduccion().add(empleadoDeduccion);
        }

        model.addAttribute("empleado", empleado);
        model.addAttribute("test", new IngresoEntity());
        model.addAttribute("puestos", puestoService.findAllPuestos());
        model.addAttribute("ingresos",ingresoService.findAllIngresos());
        model.addAttribute("deducciones", deduccionService.findAllDeducciones());
        return "empleado/crearEmpleado";
    }

    @RequestMapping(value="/empleado/crearEmpleado", method=RequestMethod.POST)
    public String guardarEmpleado(EmpleadoEntity empleadoEntity, EmpleadoIngresoEntity empleadoIngresoEntity) {

        for(EmpleadoIngresoEntity empleadoIngreso : empleadoEntity.getEmpleadoIngreso()) {
            empleadoIngreso.setEmpleadoId(empleadoEntity);
        }

        for(EmpleadoDeduccionEntity empleadoDeduccion : empleadoEntity.getEmpleadoDeduccion()) {
            empleadoDeduccion.setEmpleadoId(empleadoEntity);
        }

        EmpleadoEntity empleadoCreado = empleadoService.saveEmpleado(empleadoEntity);

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

        List<IngresoEntity> ingresos = ingresoService.findAllIngresos();

        for(IngresoEntity ingreso : ingresos) {

            boolean yaTieneIngreso = false;

            for(EmpleadoIngresoEntity empleadoIngreso : empleado.getEmpleadoIngreso()) {

                if(ingreso.getIngresoId().equals(empleadoIngreso.getIngresoId().getIngresoId())) {
                    yaTieneIngreso = true;
                }

            }

            if (yaTieneIngreso) {
                continue;
            }

            EmpleadoIngresoEntity empleadoIngresoEntity = new EmpleadoIngresoEntity();
            empleadoIngresoEntity.setEmpleadoId(empleado);
            empleadoIngresoEntity.setIngresoId(ingreso);
            empleado.getEmpleadoIngreso().add(empleadoIngresoEntity);

        }

        model.addAttribute("page", "empleado");
        model.addAttribute("empleado", empleado);
        model.addAttribute("puestos", puestoService.findAllPuestos());

        return "/empleado/editarEmpleado";
    }

    @RequestMapping(value="empleado/editarEmpleado", method=RequestMethod.POST)
    public String updateEmpleado(@ModelAttribute EmpleadoEntity empleadoEntity) {

        for(EmpleadoIngresoEntity empleadoIngreso : empleadoEntity.getEmpleadoIngreso()) {
            empleadoIngreso.setEmpleadoId(empleadoEntity);
        }

        empleadoService.updateEmpleado(empleadoEntity);
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
