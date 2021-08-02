package com.jy.netty;//package com.jy.netty;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.example.echo.EchoClientHandler;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
//public class NioSimpleClient {
//    public static void main(String[] args) {
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(workGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).
//                    handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            ChannelPipeline channelPipeline = socketChannel.pipeline();
//                            channelPipeline.addLast(new LoggingHandler
//                                    (LogLevel.INFO));
//                            channelPipeline.addLast(new EchoClientHandler());
//                        }
//                    });
//            ChannelFuture future = bootstrap.connect("127.0.0.1", 8999).sync();
//            future.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            workGroup.shutdownGracefully();
//        }
//    }
//}
