package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.IngresoEntity;
import com.cascada.domain.PuestoEntity;
import com.cascada.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Controller
@Layout(value="layouts/default")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @RequestMapping(value="/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model) {
        List<IngresoEntity> ingresos = ingresoService.findAllIngresos();
        model.addAttribute("page", "ingreso");
        model.addAttribute("ingresos", ingresos);
        return "ingreso/ingreso";
    }

}
