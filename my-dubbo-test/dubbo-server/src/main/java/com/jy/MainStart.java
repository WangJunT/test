package com.jy;

import com.jy.server.RegistryCenter;
import com.jy.server.RpcServer;
import com.jy.server.ZkRegistryCenter;

public class MainStart {
    public static void main(String[] args) throws Exception {
        RegistryCenter registryCenter = new ZkRegistryCenter();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publish("com.jy.server", registryCenter, 8889);
        rpcServer.start();
    }
}
