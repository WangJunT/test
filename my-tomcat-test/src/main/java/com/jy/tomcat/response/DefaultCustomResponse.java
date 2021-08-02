package com.jy.tomcat.response;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.apache.commons.lang3.StringUtils;

public class DefaultCustomResponse implements CustomResponse {

    private HttpRequest httpRequest;

    private ChannelHandlerContext channelHandlerContext;

    public DefaultCustomResponse(HttpRequest httpRequest, ChannelHandlerContext channelHandlerContext) {
        this.httpRequest = httpRequest;
        this.channelHandlerContext = channelHandlerContext;
    }

    @Override
    public void write(String content) throws Exception {
        if (StringUtils.isBlank(content)) {
            return;
        }
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, Unpooled.wrappedBuffer(content.getBytes("UTF-8")));
        HttpHeaders headers = response.headers();
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/json");
        headers.set(HttpHeaderNames.CONTENT_LANGUAGE, response.content().readableBytes());
        headers.set(HttpHeaderNames.EXPIRES, 0);
        if (HttpUtil.isKeepAlive(httpRequest)) {
            headers.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }
        channelHandlerContext.writeAndFlush(response);
    }
}
