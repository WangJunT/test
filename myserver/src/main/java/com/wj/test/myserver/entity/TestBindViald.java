package com.wj.test.myserver.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TestBindViald {
    @NotNull
    private Integer num;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public Integer getNum() {
        return num;
    }

    public void setNum(@Nullable Integer num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
