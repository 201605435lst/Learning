package com.linebead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月04日16:54
 */
@RestController()
@RequestMapping("/error")
public class ErrorController {


    @GetMapping("nullvalue")
    public String nullException() {
        String aa=null;
        aa.toString();
        return "null";
    }

    @GetMapping("exe")
    public String exception() {
        int i=1/0;
        return "exception";
    }





}
