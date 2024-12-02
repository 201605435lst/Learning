package com.linebead.mapper;

import com.linebead.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesMapper {

    /*批量查询*/
    List<Employee> queryBatch ( @Param("ids") List<Integer> ids);

    /*批量删除*/
    int deleteBatch ( @Param("ids") List<Integer> ids);

    /*批量插入*/
    int insertBatch ( @Param("employees") List<Employee> employees);

    /*批量更新*/
    int updateBatch ( @Param("employees") List<Employee> employees);

}
