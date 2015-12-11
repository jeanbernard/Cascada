package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.DeduccionEntity;
import com.cascada.service.DeduccionService;
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
public class DeduccionController {

    @Autowired
    private DeduccionService deduccionService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/deduccion", method = RequestMethod.GET)
    public String deduccion(Model model) {
        List<DeduccionEntity> deducciones = deduccionService.findAllDeducciones();
        model.addAttribute("page", "deduccion");
        model.addAttribute("deducciones", deducciones);
        return "deduccion/deduccion";
    }

    @RequestMapping(value="/deduccion/crearDeduccion", method = RequestMethod.GET)
    public String crearDeduccion(Model model, DeduccionEntity deduccion) {
        model.addAttribute("page", "deduccion");
        model.addAttribute("deduccion", deduccion);
        return "deduccion/crearDeduccion";
    }

    @RequestMapping(value="deduccion/crearDeduccion", method=RequestMethod.POST)
    public String guardarDeduccion(@Valid @ModelAttribute ("deduccion") DeduccionEntity deduccion, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.deduccion.nombre", null, null);
            return "deduccion/crearDeduccion";
        }

        deduccionService.saveDeduccion(deduccion);
        return "redirect:/deduccion/";
    }

    @RequestMapping(value="deduccion/edit/{deduccionId}", method=RequestMethod.GET)
    public String updateDeduccion(Model model, @PathVariable(value = "deduccionId") Long deduccionId) {

        DeduccionEntity deduccion = deduccionService.findDeduccion(deduccionId);

        model.addAttribute("page", "deduccion");
        model.addAttribute("deduccion", deduccion);

        return "/deduccion/editarDeduccion";
    }

    @RequestMapping(value="deduccion/editarDeduccion", method=RequestMethod.POST)
    public String updateDeduccion(@Valid @ModelAttribute ("deduccion") DeduccionEntity deduccion, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            messageSource.getMessage("Size.deduccion.nombre", null, null);
            return "deduccion/editarDeduccion";
        }

        deduccionService.updateDeduccion(deduccion);
        return "redirect:/deduccion/";
    }

}
