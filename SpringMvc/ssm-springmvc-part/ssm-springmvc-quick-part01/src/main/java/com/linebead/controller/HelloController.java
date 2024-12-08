package com.linebead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月03日0:27
 */
@Controller
public class HelloController {


    @RequestMapping("/springmvc/hello")
    @ResponseBody
    public String hello() {
        System.out.println("Hello Word");
        return "hello";
    }
}
