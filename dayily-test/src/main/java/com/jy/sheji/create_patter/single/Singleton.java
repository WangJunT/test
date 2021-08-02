package com.jy.sheji.create_patter.single;

//单例模式-饱汉模式
//1. 双重检测是因为 在 synchronized 可能会出现A，B两个线程抢锁的可能，
// A停留在了同步这里，而 B线程进入了完成了实例化，这个时候A线程就不能去创建了

//2. 加 volatile 关键字，防止指令重排， 如果不加 volatile ，singleton = new Singleton();
// 本来应该先是申请一段内存空间，执行构造方法，给属性赋值（1）  将得到的这个引用复制给 singleton(2)，
// 这个时候有可能发生指令重排，先给了引用，当线程A就停在 这行代码的时候，线程B去判断 singleton 就不为空，
// 就返回了一个还没有初始化完成的 对象

//3. 为什么不把 synchronized 放在方法上？ 如果实例已经被创建，在同步是没有必要的

public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){

    }
    public static  Singleton getInstance() {
        if (null == singleton) {
            //
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
