package com.jy.tomcat.servlet;

import com.jy.tomcat.request.CustomHttpRequest;
import com.jy.tomcat.response.CustomResponse;

public abstract class CustomServlet {

    public abstract void doGet(CustomHttpRequest customHttpRequest, CustomResponse customResponse);

    public abstract void doPost(CustomHttpRequest customHttpRequest, CustomResponse customResponse);
}
