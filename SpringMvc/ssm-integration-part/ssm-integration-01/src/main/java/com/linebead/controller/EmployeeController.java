package com.linebead.controller;

import com.linebead.pojo.Employee;
import com.linebead.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日10:56
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*获取员工信息*/
    @GetMapping("getEmp")
    public List<Employee> getEmp() {
        return employeeService.findAll();
    }

}
