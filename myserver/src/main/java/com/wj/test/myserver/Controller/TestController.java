package com.wj.test.myserver.Controller;

import com.wj.test.myserver.entity.TestBindViald;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {
    @RequestMapping("test")
    public String test(String name) {
        return "Hello " + name;
    }


    //@Validated和@Valid区别:嵌套校验
    @RequestMapping("/haha")
    public String haha(@Valid TestBindViald testBindViald) {
//        if (result.hasErrors()) {
//            return  "参数错误";
//        }
        return "Hello " + testBindViald.getName();
    }
}
