package com.linebead.service;

import com.linebead.mapper.UserMapper;
import com.linebead.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日15:28
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    @Override
    @Transactional
    public int delete(int id) {
        userMapper.delete(id);
//        int i = 1 / 0;
        return 0;
    }
}
