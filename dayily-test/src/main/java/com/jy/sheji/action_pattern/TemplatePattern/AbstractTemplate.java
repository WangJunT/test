package com.jy.sheji.action_pattern.TemplatePattern;

public abstract class AbstractTemplate {
    public void action() {
        init();
        apply(); // 这个是重点,可以让子类实现
        end(); // 可以作为钩子方法，可以有一个也可以有多个,如果子类有需要就实现它

    }

    protected void  end() {

    }

    protected abstract void apply();

    protected  void init() {

    }
}
