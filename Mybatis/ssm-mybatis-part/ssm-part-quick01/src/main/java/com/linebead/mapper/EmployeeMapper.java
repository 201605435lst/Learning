package com.linebead.mapper;

import com.linebead.pojo.Employee;

public interface EmployeeMapper {
    /*查询员工*/
    Employee queryEmpById(Integer id);

    Boolean deleteEmpById(Integer id);

    Employee quaryBySalary(Double salary);


    int insertEmp(Employee employee);


}
