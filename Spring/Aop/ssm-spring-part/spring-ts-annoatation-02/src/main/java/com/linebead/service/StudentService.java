package com.linebead.service;

import com.linebead.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月15日15:52
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void changeInfo(){
        studentDao.updateAgeById(88,1);
        int i = 1/0;//报错。事务回滚
        System.out.println("-----------");
        studentDao.updateNameById("事务修改name",1);
    }
}
