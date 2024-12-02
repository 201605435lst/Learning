package com.linebead.mapper;

import com.linebead.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /*根据id查找*/
    Student queryById(Integer id);

    List<Student> queryAll();
}
