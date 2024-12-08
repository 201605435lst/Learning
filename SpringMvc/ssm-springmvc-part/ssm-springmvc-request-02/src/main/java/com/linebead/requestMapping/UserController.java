package com.linebead.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月03日16:46
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String  Login(String name,Integer age){
        return "login参数"+name+age;
    }
}
