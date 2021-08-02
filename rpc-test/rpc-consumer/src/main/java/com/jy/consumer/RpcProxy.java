package com.jy.consumer;


import com.jy.entity.InvokeMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {
    public static <T> T creatProxy(Class<?> tClass) {
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass},
                (proxy, method, args) -> rpcInvoke(tClass, method, args));
    }

    private static Object rpcInvoke(Class<?> tClass, Method method, Object[] args) {
        RpcClientHandler rpcClientHandler = new RpcClientHandler();
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).
                    option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new ObjectEncoder());
                    pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                    pipeline.addLast(rpcClientHandler);
                }
            });
            ChannelFuture future = bootstrap.connect("localhost", 8888).sync();
            InvokeMessage invokeMessage = new InvokeMessage();
            invokeMessage.setClassName(tClass.getName());
            invokeMessage.setMethodName(method.getName());
            invokeMessage.setParamsType(method.getParameterTypes());
            invokeMessage.setParamsValues(args);
            future.channel().writeAndFlush(invokeMessage);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }
        return rpcClientHandler.getResult();
    }
}
