package com.jy.sheji.decorate;

public class DecoratorB extends Decorator {
    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        super.doSomeThing();
        doOtherThing();
    }
    public void doOtherThing() {
        System.out.println("装饰类B");
    }
}
