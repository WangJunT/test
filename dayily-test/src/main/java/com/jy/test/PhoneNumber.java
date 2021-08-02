package com.jy.test;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    private static final String[] strings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> stringList;

    public static List<String> letterCombinations(String digits) {
        stringList = new ArrayList<>();
        if ("".equals(digits)) {
            return stringList;
        }
        spilt("", digits, 0);
        return stringList;
    }

    public static void spilt(String result, String digits, int index) {
        if (index == digits.length()) {
            stringList.add(result);
            return;
        }
        String a = strings[digits.charAt(index) - '2'];
        for (int i = 0; i < a.length(); i++) {
            spilt(result + a.charAt(i), digits, index + 1);
        }
        return;
    }

    public static void main(String[] args) {
        letterCombinations("23");
        System.out.println(1);
    }

}
