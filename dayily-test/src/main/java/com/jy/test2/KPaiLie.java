package com.jy.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KPaiLie {
    private static List<String> list;
    private static int index;

    public static String getPermutation(int n, int k) {
        list = new ArrayList<>();
        boolean[] flags = new boolean[n];
        digui(n, "", flags, k);
        if (list.size() == 0 || null == list) {
            return "";
        }
        return list.get(k - 1);
    }

//    public static String getPermutation2(int n, int k) {
//        for () {
//
//        }
//        return "";
//    }

    private int total(int n) {
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum = sum * i;
        }
        return sum;
    }

    private static void digui(int n, String s, boolean[] flags, int k) {
        if (s.length() == n) {
            list.add(s);
            index++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (flags[i - 1]) {
                continue;
            }
            if (index >= k) {
                return;
            }
            String newString = s + i;
            boolean[] newFlag = Arrays.copyOf(flags, n);
            newFlag[i - 1] = true;
            digui(n, newString, newFlag, k);
        }
    }

    public static void main(String[] args) {
        String s = getPermutation(8, 1907);
        System.out.println(s);
    }
}
