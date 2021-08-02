package com.jy.sheji.decorate;

public class DecoratorA extends Decorator {
    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        super.doSomeThing();
        doOtherThing();
    }
    public void doOtherThing() {
        System.out.println("装饰类A");
    }
}
