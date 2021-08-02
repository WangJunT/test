package com.jy.string;

import java.util.ArrayList;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        test(4000000);
    }

    private static void test(int cnt) {
        final List<String> lst = new ArrayList<String>(1024);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "Very very very very very very very very very very very very very very " +
                    "very long string: " + i;
//            lst.add(str.intern());
            lst.add(str);
            if (i % 200000 == 0) {
                System.out.println(i + 200000 + "; time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + lst.size());
    }
}
