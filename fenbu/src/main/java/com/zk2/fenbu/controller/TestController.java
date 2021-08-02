package com.zk2.fenbu.controller;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ZooKeeper zooKeeper;


    @RequestMapping("test")
    public String test() throws KeeperException, InterruptedException {
        zooKeeper.exists("/Hello", true);
        return "";
    }

    @RequestMapping("test1")
    public String test1(String path) throws KeeperException, InterruptedException {
        zooKeeper.setData(path, "aaa".getBytes(), -1);
        zooKeeper.exists(path, true);
        zooKeeper.setData(path, "aaaaaa".getBytes(), -1);
        zooKeeper.exists(path, true);
        return "";
    }
}
