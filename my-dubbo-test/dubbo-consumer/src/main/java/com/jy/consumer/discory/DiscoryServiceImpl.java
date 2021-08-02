package com.jy.consumer.discory;

import com.jy.consumer.balance.RandomBalanceService;
import com.jy.entity.ZKConstant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

public class DiscoryServiceImpl implements DiscoryService {

    private CuratorFramework curator;

    public DiscoryServiceImpl() {
        this.curator = CuratorFrameworkFactory.builder().
                connectString(ZKConstant.ZK_CLUSTER).
                sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000, 10)).
                build();
        this.curator.start();
    }

    List<String> servers = new ArrayList<>();

    @Override
    public String discoryServer(String serviceName) {
        try {
            String servicePath = ZKConstant.ZK_DUBBO_ROOT_PATH + "/" + serviceName;
            servers = curator.getChildren().forPath(servicePath);
            if (servers.size() == 0) {
                return null;
            }
            registerWatch(servicePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RandomBalanceService().choose(servers);
    }

    private void registerWatch(String servicePath) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(curator, servicePath, true);
        cache.getListenable().addListener((client, event) ->
                servers = client.getChildren().forPath(servicePath)
        );
        cache.start();
    }
}
