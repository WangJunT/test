package com.jy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline p = socketChannel.pipeline();
                    p.addLast("httpServerCodec",new HttpServerCodec());
                    p.addLast(new SimpleChannelInboundHandler<HttpObject>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
                            if (httpObject instanceof HttpRequest) {
//                                HttpMethod = ;

                                System.out.println(1111111);
                                ByteBuf byteBuffer = Unpooled.copiedBuffer("Hello Wang", CharsetUtil.UTF_8);
                                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuffer);
                                response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
                                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuffer.readableBytes());
                                channelHandlerContext.writeAndFlush(response);
                            }
                        }
                    });
                }

            });
            ChannelFuture sync = serverBootstrap.bind(8899).sync();
            sync.channel().closeFuture().sync();
        }finally {
            //8.优雅关闭相关线程组资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
