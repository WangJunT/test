package com.jy.tomcat.request;

import java.util.List;
import java.util.Map;

public interface CustomHttpRequest {
    String getUri();
    String getMethod();
    Map<String, List<String>> getParameters();
    List<String> getParameters(String name);
    String getPath();

    String getParameter(String name);
}
