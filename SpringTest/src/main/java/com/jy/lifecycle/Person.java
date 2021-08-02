package com.jy.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private Integer id;
    private String name;
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Person() {
        System.out.println("person 构造函数");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware: " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    public void init() {
        System.out.println("init person");
    }

    public void destory() {
        System.out.println("destory person");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++) {
            int a = nums[i];
            while(a>0) {
                int yu = a%10;
                a= a/10;
                list.add(yu);
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            stringBuilder.append(list.get(i));
        }
        stringBuilder.toString();
    }
}
