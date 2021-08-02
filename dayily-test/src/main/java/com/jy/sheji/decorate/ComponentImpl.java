package com.jy.sheji.decorate;

public class ComponentImpl implements Component {
    @Override
    public void doSomeThing() {
        System.out.println("原有类输出");
    }
}
