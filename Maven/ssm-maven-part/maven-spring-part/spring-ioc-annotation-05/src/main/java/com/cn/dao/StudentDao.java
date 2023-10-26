package com.cn.dao;

import com.cn.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
     List<Student> queryAll();
}
