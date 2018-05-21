package com.xubh.springboot.controller;

import com.xubh.springboot.bean.Department;
import com.xubh.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getOneById(@PathVariable("id") Integer id) {
        return deptService.getOneById(id);
    }

}
