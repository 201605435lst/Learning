package com.linebead.mapper;


import com.linebead.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    /*根据员工id查姓名*/

    String queryEmpNameById(Integer id);

    Map<String,Object> selectEmpNameAndMaxSalary();

    /*查询全部员工信息*/
    List<Employee> queryAllEmp();

    List<String> queryAllEmpName(Double salary);

}
