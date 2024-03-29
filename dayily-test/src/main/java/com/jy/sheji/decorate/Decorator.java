package com.jy.sheji.decorate;

public class Decorator implements Component {
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomeThing() {
        component.doSomeThing();
    }
}
