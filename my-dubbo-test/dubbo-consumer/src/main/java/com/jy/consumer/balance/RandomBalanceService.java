package com.jy.consumer.balance;

import java.util.List;
import java.util.Random;

public class RandomBalanceService implements LoadBalanceService{

    @Override
    public String choose(List<String> servers) {
        int index = new Random().nextInt(servers.size());
        return servers.get(index);
    }
}
