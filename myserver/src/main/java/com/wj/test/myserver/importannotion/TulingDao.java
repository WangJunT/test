package com.wj.test.myserver.importannotion;

public class TulingDao {
    public TulingDao() {
        System.out.println("我是通过ImportBeanDefinitionRegistrar导入进来tulingDao组件");
    }
    public void testTulingDao() {
        System.out.println("我是通过ImportBeanDefinitionRegistrar导入进来tulingDao组件");
    }
}
