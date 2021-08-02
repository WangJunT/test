//package com.zk2.fenbu;
//
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.springframework.stereotype.Component;
//
//import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;
//
//@Component(value = "zkClientWatcher")
//public class ZkClientWatcher implements Watcher {
//    @Override
//    public void process(WatchedEvent event) {
//        System.out.println("fenbu==-===");
//        if (event.getType() == NodeDataChanged) {
//            System.out.println(event.getPath());
//        }
//    }
//}
