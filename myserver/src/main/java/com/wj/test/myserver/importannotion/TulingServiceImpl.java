package com.wj.test.myserver.importannotion;

import org.springframework.beans.factory.annotation.Autowired;

public class TulingServiceImpl {
    @Autowired
            TulingDao tulingDao;
    TulingServiceImpl() {
        System.out.println("我是通过importSelector导入进来的service");
//        tulingDao.testTulingDao();
    }
    public void testService() {
        System.out.println("我是通过importSelector导入进来的service");
    }
}
