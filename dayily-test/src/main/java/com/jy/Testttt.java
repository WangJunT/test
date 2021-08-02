package com.jy;


public class Testttt {

    public static final Integer CONSTANT_1 = 666;

    public int math() {
        int a = 19;
        int b = 5;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Testttt math = new Testttt();
        math.math();
//        Map<String, String> map = new HashMap<>();
//        map.put("test", "test");
//        new Thread().start();
        System.out.println("end");
    }
}
