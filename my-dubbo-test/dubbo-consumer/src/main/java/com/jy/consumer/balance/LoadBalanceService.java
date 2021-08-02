package com.jy.consumer.balance;

import java.util.List;

public interface LoadBalanceService {
    String choose(List<String> servers);
}
