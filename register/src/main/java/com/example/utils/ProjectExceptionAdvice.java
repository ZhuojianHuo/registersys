package com.example.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R handleException(Exception e){
        e.printStackTrace();
        return new R(false,"服务器故障，请联系管理员！");
    }
}
