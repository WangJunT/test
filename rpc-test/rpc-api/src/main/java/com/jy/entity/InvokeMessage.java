package com.jy.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvokeMessage implements Serializable {
    private String className;
    private String methodName;
    private Object[] paramsValues;
    private Class<?>[] paramsType;
}
