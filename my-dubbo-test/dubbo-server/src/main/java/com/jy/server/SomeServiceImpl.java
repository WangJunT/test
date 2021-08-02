package com.jy.server;

import com.jy.service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public String doSome(String param) {
        System.out.println(111111111);
        return param + "xxxxaaaa";
    }
}
