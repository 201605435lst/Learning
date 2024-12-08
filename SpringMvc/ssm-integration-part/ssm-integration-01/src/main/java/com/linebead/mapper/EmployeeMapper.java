package com.linebead.mapper;

import com.linebead.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日10:27
 */

@Repository
/*存放从数据库获取数据的接口*/
public interface EmployeeMapper {

    List<Employee> selectAll();

}
