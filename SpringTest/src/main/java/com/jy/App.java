package com.jy;

import com.jy.lifecycle.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scripting.Messenger;

/**
 * Hello world!
 */
public class App {
    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("scripting/beans.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }
}
