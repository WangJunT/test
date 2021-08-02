package com.jy.server;

import com.jy.service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public String doSome(String param) {
        return param + "xxxxaaaa";
    }
}
