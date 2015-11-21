package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jbernard on 11/18/2015.
 */

@Controller
@Layout(value="layouts/default")
public class DepartmentController {

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("page", "department");
        return "department/department";
    }

    @RequestMapping(value = "/department/crear", method = RequestMethod.GET)
    public String creardepartment(Model model) {
        model.addAttribute("page", "department");
        return "department/createDepartment";
    }

    @RequestMapping(value="department/crear", method=RequestMethod.POST)
    public String guardardepartment(Department department) {

        return "redirect:/crear";
    }


}
