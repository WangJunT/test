package com.jy.netty;//package com.jy.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.example.echo.EchoServerHandler;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
//public class NioSimpleServer {
//    public static void main(String[] args) {
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).
//                    option(ChannelOption.SO_BACKLOG, 100).handler(new LoggingHandler
//                    (LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
//                @Override
//                protected void initChannel(SocketChannel socketChannel) throws Exception {
//                    ChannelPipeline p = socketChannel.pipeline();
//                    p.addLast(new LoggingHandler
//                            (LogLevel.INFO));
//                    p.addLast(new EchoServerHandler());
//                }
//            });
//            ChannelFuture future = serverBootstrap.bind(8999).sync();
//            future.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workGroup.shutdownGracefully();
//        }
//    }
//}
