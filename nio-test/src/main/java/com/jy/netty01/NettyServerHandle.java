package com.jy.netty01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyServerHandle extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf read = (ByteBuf) msg;
        System.out.println(read.toString(CharsetUtil.UTF_8));
        ByteBuf write = Unpooled.copiedBuffer("已收到你的请求", CharsetUtil.UTF_8);
        ctx.writeAndFlush(write);
    }
}
