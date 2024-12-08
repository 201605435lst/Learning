package com.linebead.mapper;

import com.linebead.pojo.Student;

/**
* @author liushengtao
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-12-02 23:24:51
* @Entity com.linebead.pojo.Student
*/
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
