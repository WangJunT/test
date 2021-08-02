package com.jy.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.File;
import java.net.URL;
import java.util.*;

public class RpcServer {

    private Map<String, Object> serverMap = new HashMap<>();

    //    private List<String> serverClassNameList = Collections.synchronizedList(new ArrayList<>());
    private List<String> serverClassNameList = new ArrayList<>();

    public void publish(String provicerPackage) throws Exception {
        getProviderClass(provicerPackage);
        registerServers();
    }

    private void registerServers() throws Exception {
        if (serverClassNameList == null || serverClassNameList.isEmpty()) {
            return;
        }
        for (String className : serverClassNameList) {
            Class<?> classz = Class.forName(className);
            if (classz.getInterfaces() != null && classz.getInterfaces().length != 0) {

                String interfaceName = classz.getInterfaces()[0].getName();
                serverMap.put(interfaceName, classz.newInstance());
            }
        }

    }

    private void getProviderClass(String provicerPackage) {
        URL resource = this.getClass().getClassLoader().
                getResource(provicerPackage.replaceAll("\\.", "/"));
        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                getProviderClass(provicerPackage + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String fileName = file.getName().replace(".class", "").trim();
                serverClassNameList.add(provicerPackage + "." + fileName);
            }
        }
    }

    public void start() {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap().group(parentGroup, childGroup).
                    option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(new RpcHandler(serverMap));
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
            System.out.println("服务注册成功，端口号 8888");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

    }
}
