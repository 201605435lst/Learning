package com.lbd.service;

import com.lbd.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年04月03日10:57
 */

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;


    @Override
    @Transactional()
    public Boolean changeInfo(String name, Integer age, Integer id) {
        studentDao.updateAgeById(age, id);
        studentDao.updateNameById(name, id);
        return true;
    }
}
