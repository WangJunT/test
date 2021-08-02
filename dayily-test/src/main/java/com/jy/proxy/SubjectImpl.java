package com.jy.proxy;

public class SubjectImpl implements Subject {
    @Override
    public String sayHello(String name) {
        String s = "hello " + name;
        System.out.println(s);
        return s;
    }
}
