package com.jy.sheji.decorate;

public class Client {
    public static void main(String[] args) {
        DecoratorA decoratorA = new DecoratorA(new DecoratorB(new ComponentImpl()));
        DecoratorB decoratorB = new DecoratorB(new DecoratorA(new ComponentImpl()));
        decoratorA.doSomeThing();
        decoratorB.doSomeThing();
    }
}
