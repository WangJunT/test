package com.jy;

import com.jy.server.RpcServer;

public class MainStart {
    public static void main(String[] args) throws Exception {
        RpcServer rpcServer = new RpcServer();
        rpcServer.publish("com.jy.server");
        rpcServer.start();
    }
}
