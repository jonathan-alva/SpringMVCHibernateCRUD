package com.jwt.controller;

import com.jwt.model.Department;

import com.jwt.service.DepartmentService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class DepartmentController {
    private static final Logger logger = Logger.getLogger(DepartmentController.class);

    public DepartmentController(){
        System.out.println("DepartmentController()");
    }

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department")
    public ModelAndView listDepartment(ModelAndView model) throws IOException {
        List<Department> listDepartment = departmentService.getAllDepartments();
        model.addObject("listDepartment", listDepartment);
        model.setViewName("DepartmentList");
        return model;
    }

    @RequestMapping(value = "/department/newDepartment", method = RequestMethod.GET)
    public ModelAndView newDepartment(ModelAndView model) {
        Department department = new Department();
        model.addObject("department", department);
        model.setViewName("DepartmentForm");
        return model;
    }

    @RequestMapping(value = "/department/saveDepartment", method = RequestMethod.POST)
    public ModelAndView saveDepartment(@ModelAttribute Department department) {
        if (department.getId() == 0) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }
        return new ModelAndView("redirect:/department");
    }

    @RequestMapping(value = "/department/deleteDepartment", method = RequestMethod.GET)
    public ModelAndView deleteDepartment(HttpServletRequest request) {
        int departmentId = Integer.parseInt(request.getParameter("id"));
        departmentService.deleteDepartment(departmentId);
        return new ModelAndView("redirect:/department");
    }

    @RequestMapping(value = "/department/editDepartment", method = RequestMethod.GET)
    public ModelAndView editDepartment(HttpServletRequest request) {
        int departmentId = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.getDepartment(departmentId);
        ModelAndView model = new ModelAndView("DepartmentForm");
        model.addObject("department", department);
        return model;
    }
}
