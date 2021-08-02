package com.jy.netty04;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerEventHandle extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String aa = null;
            switch (event.state()) {
                case READER_IDLE:
                    aa = "读超时";
                    break;
                case WRITER_IDLE:
                    aa = "写超时";
                    break;
                case ALL_IDLE:
                    aa = "都超时";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件" + aa);
            ctx.channel().close();
        }
    }
}
