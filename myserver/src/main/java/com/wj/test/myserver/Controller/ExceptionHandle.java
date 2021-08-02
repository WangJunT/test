package com.wj.test.myserver.Controller;


import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandle {
    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().
                map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return "参数错误";
    }

}
