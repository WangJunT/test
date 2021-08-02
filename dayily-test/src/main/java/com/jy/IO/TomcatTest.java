package com.jy.IO;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatTest {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        Connector connector = new Connector("HTTP/1.1");
        connector.setPort(8080);
        tomcat.setConnector(connector);
        Connector connector1 = new Connector("HTTP/1.1");
        connector1.setPort(8081);
        tomcat.setConnector(connector1);
        tomcat.start();
        tomcat.getServer().await();
    }
}
