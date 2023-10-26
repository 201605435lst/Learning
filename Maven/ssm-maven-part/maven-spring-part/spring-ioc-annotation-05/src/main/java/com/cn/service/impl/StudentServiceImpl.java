package com.cn.service.impl;

import com.cn.dao.StudentDao;
import com.cn.pojo.Student;
import com.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.queryAll();
    }
}
