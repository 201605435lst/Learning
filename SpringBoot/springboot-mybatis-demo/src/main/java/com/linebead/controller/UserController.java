package com.linebead.controller;

import com.linebead.pojo.User;
import com.linebead.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日15:30
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll() {
        log.info("findAll");
        return userService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public int delete(@PathVariable int id) {
        log.info("delete");
        return userService.delete(id);
    }

}
