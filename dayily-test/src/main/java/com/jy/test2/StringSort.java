package com.jy.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//字符串排列
public class StringSort {
    private static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        boolean[] flag = new boolean[s.length()];
        sortString("abc", flag, new ArrayList<>());
        System.out.println(1);
    }

    private static void sortString(String abc, boolean[] flag, List<String> stringList) {
        if (stringList.size() >= abc.length()) {
            list.add(stringList);
            return;
        }
        for (int i = 0; i < abc.length(); i++) {
            if (!flag[i]) {
                boolean[] booleans = Arrays.copyOf(flag, flag.length);
                ArrayList<String> strings = new ArrayList<>(stringList);
                strings.add(abc.substring(i, i + 1));
                booleans[i] = true;
                sortString(abc, booleans, strings);
            }
        }
    }
}
