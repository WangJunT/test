package com.jy.test;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            flag = true;
        }
        long newDividend = Math.abs((long) dividend);
        long newDivisor = Math.abs((long) divisor);
        if (newDividend < newDivisor) {
            return 0;
        }
        long tmp = newDivisor;
        int num = 1;
        while (newDividend >= newDivisor) {
            long a = newDivisor << 1;
            if (newDividend >= a) {
                newDivisor = a;
                num = num << 1;
            } else {
                break;
            }
        }
        newDividend = newDividend - newDivisor;
        while (newDividend >= tmp) {
            newDividend = newDividend - tmp;
            num++;
        }
        return !flag ? -num : num;
    }

    public static void main(String[] args) {
        divide(10, 3);
    }
}
