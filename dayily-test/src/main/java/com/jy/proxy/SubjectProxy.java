package com.jy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectProxy implements InvocationHandler {
    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method");
        Object invoke = method.invoke(subject, args);
        System.out.println("after method");
        return invoke;
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
//        subject.sayHello("nima");
        InvocationHandler handler = new SubjectProxy(subject);
        Subject instance = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                new Class[]{Subject.class}, handler);
        instance.sayHello("jy");
    }
}
