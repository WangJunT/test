package com.jy.server;

import com.jy.entity.ZKConstant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZkRegistryCenter implements RegistryCenter {

    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder().
                connectString(ZKConstant.ZK_CLUSTER).
                sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000, 10)).
                build();
        curatorFramework.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        try {
            String servicePath = ZKConstant.ZK_DUBBO_ROOT_PATH + "/" + serviceName;
            if (curatorFramework.checkExists().forPath(servicePath) == null) {
                curatorFramework.create().creatingParentsIfNeeded().
                        withMode(CreateMode.PERSISTENT).forPath(servicePath, "0".getBytes());
            }

            String addressPath = servicePath + "/" + serviceAddress;
            if (curatorFramework.checkExists().forPath(addressPath) == null) {
                String hostNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL).
                        forPath(addressPath, "1".getBytes());
                System.out.println("Service Host register Success!" + hostNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
