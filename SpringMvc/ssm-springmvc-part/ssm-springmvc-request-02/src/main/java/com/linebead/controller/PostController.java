package com.linebead.controller;

import com.linebead.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月03日23:07
 */
@Controller
@RequestMapping("/post")
@ResponseBody
public class PostController {


    @PostMapping("/postValue")
    public String getPostValue(@RequestBody Person person) {
        System.out.println("getPostValue"+person);
        return "post" + person.getName() + person.getAge();
    }

}
