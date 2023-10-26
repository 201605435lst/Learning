package com.ioc_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Controller
public class UserController {

//    @Autowired
//    @Qualifier(value = "userServiceImpl")
    @Resource(name = "userServiceImpl")
    private UserService userService;


    public void show(){
        userService.show();
    }

}
