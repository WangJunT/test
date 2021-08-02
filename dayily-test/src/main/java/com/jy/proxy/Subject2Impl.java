package com.jy.proxy;

public class Subject2Impl implements  Subject{
    @Override
    public String sayHello(String name) {
        System.out.println("Hello  Test"+ name);
        return null;
    }
}
