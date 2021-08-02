package com.jy.tomcat.response;

public interface CustomResponse {
    void write(String content) throws Exception;
}
