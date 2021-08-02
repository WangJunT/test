package com.jy.netty01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandle extends ChannelInboundHandlerAdapter {
    //客户端和服务端的连接建立之后就会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf write = Unpooled.copiedBuffer("帅哥你好！", CharsetUtil.UTF_8);
        ctx.writeAndFlush(write);
        super.channelActive(ctx);
    }

    //客户端接收服务端发送数据调用的方法
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf a  = (ByteBuf)msg;
        System.out.println(a.toString(CharsetUtil.UTF_8));
        super.channelRead(ctx, msg);
    }
}
