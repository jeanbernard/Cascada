package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.*;
import com.cascada.service.*;
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
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private DeduccionService deduccionService;

    @Autowired
    private EmpleadoIngresoService empleadoIngresoService;

    @Autowired
    private EmpleadoDeduccionService empleadoDeduccionService;


    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/nomina", method = RequestMethod.GET)
    public String nomina(Model model) {
        List<NominaEntity> nominas = nominaService.findAllNominas();
        model.addAttribute("page", "nomina");
        model.addAttribute("nominas", nominas);
        return "nomina/nomina";
    }

    @RequestMapping(value="/nomina/crearNomina", method = RequestMethod.GET)
    public String crearNomina(Model model, NominaEntity nomina) {

        model.addAttribute("page", "nomina");
        model.addAttribute("nomina", nomina);

        return "nomina/crearNomina";
    }

    @RequestMapping(value="nomina/crearNomina", method=RequestMethod.POST)
    public String guardarNomina(@Valid @ModelAttribute("nomina") NominaEntity nomina, BindingResult bindingResult) {

        List<NominaEntity> allNominas = nominaService.findAllNominas();

        for(NominaEntity nominaDB : allNominas) {
            if(nominaDB.getNombre().equals(nomina.getNombre())) {
                return "nomina/crearNomina";
            }
        }

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.nomina.nombre", null, null);
            return "nomina/crearNomina";
        }

        nominaService.saveNomina(nomina);
        return "redirect:/nomina/";
    }

    @RequestMapping(value="nomina/edit/{nominaId}", method=RequestMethod.GET)
    public String updateNomina(Model model, @PathVariable(value = "nominaId") Long nominaId) {

        NominaEntity nomina = nominaService.findNomina(nominaId);

        List<EmpleadoIngresoEntity> allEmpleadoIngresos = empleadoIngresoService.findAllEmpleadoIngresos();
        List<EmpleadoDeduccionEntity> allEmpleadoDeduducciones = empleadoDeduccionService.findAllEmpleadoDeduccion();
        List<IngresoEntity> allIngresos = ingresoService.findAllIngresos();
        List<DeduccionEntity> allDeducciones = deduccionService.findAllDeducciones();

        model.addAttribute("page", "nomina");
        model.addAttribute("nomina", nomina);
        model.addAttribute("ingresos", allIngresos);
        model.addAttribute("deducciones", allDeducciones);

        return "/nomina/editarNomina";
    }

    @RequestMapping(value="nomina/editarNomina", method=RequestMethod.POST)
    public String updateNomina(@Valid @ModelAttribute("nomina") NominaEntity nomina, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.nomina.nombre", null, null);
            return "nomina/editarNomina";
        }

        nominaService.updateNomina(nomina);
        return "redirect:/nomina/";
    }

}
