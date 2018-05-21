package com.xubh.springboot.controller;

import com.xubh.springboot.bean.Employee;
import com.xubh.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee empById = employeeService.getEmpById(id);
        return empById;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpBylastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpBylastName(lastName);
    }

}
