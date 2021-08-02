package com.jy;

import com.jy.consumer.RpcProxy;
import com.jy.service.SomeService;

public class ConsumeTest {
    public static void main(String[] args) {
        SomeService someService = RpcProxy.creatProxy(SomeService.class);
        String test = someService.doSome("test");
        System.out.println(test);
    }
}
