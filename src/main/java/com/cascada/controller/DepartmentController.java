package com.cascada.controller;

import com.cascada.annotations.Layout;
import com.cascada.domain.Department;
import com.cascada.repository.DepartmentRepository;
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
public class DepartmentController {

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Autowired
    private DepartmentRepository departmentRepository;


    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("page", "department");
        return "department/department";
    }

    @RequestMapping(value = "/department/createDepartment", method = RequestMethod.GET)
    public String createDepartment(Model model) {
        model.addAttribute("page", "department");
        model.addAttribute("department", new Department());
        return "department/createDepartment";
    }

    @RequestMapping(value="department/createDepartment", method=RequestMethod.POST)
    public String submitDepartment(Department department) {
        departmentRepository.saveDepartment();
        return "redirect:/department/createDepartment/";
    }


}
