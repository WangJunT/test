package com.jy.test;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntToLuoMa {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            int count = num / 1000;
            for (int i = 0; i < count; i++) {
                sb.append("M");
            }
            num = num % 1000;
        }
        if (num >= 900) {
            sb.append("CM");
            num = num - 900;
        }
        if (num >= 500) {
            sb.append("D");
            num = num - 500;
        }
        if (num >= 400) {
            sb.append("CD");
            num = num - 400;
        }
        if (num >= 100) {
            int count = num / 100;
            for (int i = 0; i < count; i++) {
                sb.append("C");
            }
            num = num % 100;
        }
        if (num >= 90) {
            sb.append("XC");
            num = num - 90;
        }
        if (num >= 50) {
            sb.append("L");
            num = num - 50;
        }
        if (num >= 40) {
            sb.append("XL");
            num = num - 40;
        }
        if (num >= 10) {
            int count = num / 10;
            for (int i = 0; i < count; i++) {
                sb.append("X");
            }
            num = num % 10;
        }
        if (num >= 9) {
            sb.append("IX");
            num = num - 9;
        }
        if (num >= 5) {
            sb.append("V");
            num = num - 5;
        }
        if (num >= 4) {
            sb.append("IV");
            num = num - 5;
        }
        if (num >= 1) {
            int count = num / 1;
            for (int i = 0; i < count; i++) {
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
