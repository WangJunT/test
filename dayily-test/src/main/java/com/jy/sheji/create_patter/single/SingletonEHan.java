package com.jy.sheji.create_patter.single;
//饿汉模式
public class SingletonEHan {
    //一定要加！
    private SingletonEHan() {

    }
    private static final  SingletonEHan si  = new SingletonEHan();
    public static SingletonEHan getInstance() {

        return si;
    }

}

