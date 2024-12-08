package com.linebead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日20:44
 */
@RestController
@RequestMapping("hello")
public class HelloController {


    @GetMapping("hello")
    public String Hello() {
        System.out.println("hello");
        return "Hello你好";
    }

}
