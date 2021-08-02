package com.jy.tomcat.request;


import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class DefaultCustomHttpRequest implements CustomHttpRequest {

    private HttpRequest httpRequest;

    public DefaultCustomHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public String getUri() {
        return httpRequest.uri();
    }

    @Override
    public String getMethod() {
        return httpRequest.method().name();
    }

    @Override
    public Map<String, List<String>> getParameters() {
        QueryStringDecoder decoder = new QueryStringDecoder(httpRequest.getUri());
        return decoder.parameters();
    }

    @Override
    public List<String> getParameters(String name) {
        Map<String, List<String>> listMap = this.getParameters();
        List<String> paramter = listMap.get(name);
        return paramter;
    }

    @Override
    public String getPath() {
        QueryStringDecoder decoder = new QueryStringDecoder(httpRequest.getUri());
        return decoder.path();
    }

    @Override
    public String getParameter(String name) {
        List<String> list = this.getParameters(name);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
