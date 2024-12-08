package com.linebead.controller;

import com.linebead.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日12:22
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("get-user")
    public List<User> getUser() {

        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return userList;

    }

}
