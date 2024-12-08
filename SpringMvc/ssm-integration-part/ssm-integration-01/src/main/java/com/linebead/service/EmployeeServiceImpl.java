package com.linebead.service;


import com.linebead.mapper.EmployeeMapper;
import com.linebead.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日10:52
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAll() {
        return employeeMapper.selectAll();
    }
}
