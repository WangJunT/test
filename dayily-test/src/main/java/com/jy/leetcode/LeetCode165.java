package com.jy.leetcode;

public class LeetCode165 {
    public static int compareVersion(String version1, String version2) {
        String ver1[] = version1.split("\\.");
        String ver2[] = version2.split("\\.");
        int i = 0, j = 0;
        for (; i < ver1.length || j < ver2.length;
             i++, j++) {
            int a = i < ver1.length ? Integer.valueOf(ver1[i]) : 0;
            int b = j < ver2.length ? Integer.valueOf(ver1[j]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("0.1", "1.1");
        System.out.println(1);
    }
}
