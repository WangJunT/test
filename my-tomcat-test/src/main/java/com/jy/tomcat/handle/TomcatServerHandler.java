package com.jy.tomcat.handle;

import com.jy.tomcat.request.CustomHttpRequest;
import com.jy.tomcat.request.DefaultCustomHttpRequest;
import com.jy.tomcat.response.CustomResponse;
import com.jy.tomcat.response.DefaultCustomResponse;
import com.jy.tomcat.servlet.SomeServlet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

public class TomcatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            SomeServlet servlet = new SomeServlet();
            CustomHttpRequest customHttpRequest = new DefaultCustomHttpRequest(request);
            CustomResponse customResponse = new DefaultCustomResponse(request, ctx);
            servlet.doGet(customHttpRequest, customResponse);
        }
    }
}
