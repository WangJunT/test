package com.jy.server;

import com.jy.entity.InvokeMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

public class RpcHandler extends SimpleChannelInboundHandler<InvokeMessage> {
    private Map<String, Object> serverMap;

    public RpcHandler(Map<String, Object> serverMap) {
        this.serverMap = serverMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, InvokeMessage msg) throws Exception {
        if (null == serverMap || serverMap.size() == 0) {
            return;
        }
        Object result = "没有该提供方法";
        if (serverMap.containsKey(msg.getClassName())) {
            Object object = serverMap.get(msg.getClassName());
            result = object.getClass().
                    getMethod(msg.getMethodName(), msg.getParamsType()).
                    invoke(object, msg.getParamsValues());
        }
        ctx.writeAndFlush(result);
        ctx.close();
    }
}
