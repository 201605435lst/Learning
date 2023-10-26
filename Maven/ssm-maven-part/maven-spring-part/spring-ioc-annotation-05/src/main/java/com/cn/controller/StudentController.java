package com.cn.controller;

import com.cn.pojo.Student;
import com.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public List<Student> findAll(){
      return   studentService.findAll();
    }

}
