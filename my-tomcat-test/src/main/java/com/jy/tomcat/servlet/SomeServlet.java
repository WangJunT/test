package com.jy.tomcat.servlet;

import com.jy.tomcat.request.CustomHttpRequest;
import com.jy.tomcat.response.CustomResponse;

public class SomeServlet extends CustomServlet {
    @Override
    public void doGet(CustomHttpRequest request, CustomResponse response) {
        String param = request.getParameter("name");
        String uri = request.getUri();
        String method = request.getMethod();
        String path = request.getPath();
        String content = "method = " + method + "\n" +
                "uri = " + uri + "\n" +
                "path = " + path + "\n" +
                "param = " + param;
        try {
            response.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(CustomHttpRequest customHttpRequest, CustomResponse customResponse) {
        doGet(customHttpRequest, customResponse);
    }
}
