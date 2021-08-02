package com.zk2.fenbu.bean;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;

@Configuration
public class ZkConfig {

    @Bean(name = "zooKeeper")
    public ZooKeeper createZooKeeper(Watcher zkClientWatcher) throws IOException {
        ZooKeeper zookeeper = new ZooKeeper("39.107.118.219:2182",
                500000, zkClientWatcher);
        return zookeeper;
    }

    @Bean(name = "zkClientWatcher")
    public Watcher createWatch() throws IOException {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("fenbu==-===");
                if (event.getType() == NodeDataChanged) {
                    System.out.println(event.getPath());
                }
            }
        };
        return watcher;
    }
}
