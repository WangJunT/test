package com.jy.sheji.create_patter.factory;

public class SimpleFactory {
    public static Food getFood(String food) {
        if ("noodle".equals(food)) {
            return new Noodle();
        } else if ("dumplings".equals(food)) {
            return new Dumpling();
        } else {
            return null;
        }
    }
}
