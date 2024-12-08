package com.linebead.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liushengtao
 * @description 异常拦截处理
 * @date 2024年12月04日16:47
 */
@RestControllerAdvice
public class ExceptionController {



    /*空指针异常*/
    @ExceptionHandler(NullPointerException.class)
    public String nullException(NullPointerException e) {
        System.out.println(e.getMessage());
        return "null";
    }

    @ExceptionHandler
    public String exception(Exception e) {
        System.out.println(e.getMessage());
        return "exception";
    }



}
