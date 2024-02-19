package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String EmployeeList(Model model) {
        List<Employee> myEmployee = employeeService.findAll();
        model.addAttribute("employeeList", myEmployee);
        return "Employee/EmployeeList-Controller";
    }

    @GetMapping("/formFillUp")
    public String PassData(Model myModel) {
        Employee employee = new Employee();
        myModel.addAttribute("EmployeeData",employee);
        return "Employee/formFillUp";
    }

    @PostMapping("/saveData")
    public String SaveData(@ModelAttribute("EmployeeData") Employee employee){
        employeeService.save(employee);
        return "redirect:/Employee/list";
    }
    @GetMapping("/updationProcess")
    public String updationProcess(@RequestParam("updateId") int id, Model myModel){
      Employee employee= employeeService.findById(id);
      myModel.addAttribute("EmployeeData",employee);
      return "Employee/formFillUp";

    }
    @GetMapping("/deletionProcess")
    public String deleteEmployee(@RequestParam("deleteId") int id){
        employeeService.deleteById(id);
        return "redirect:/Employee/list";
    }
}

