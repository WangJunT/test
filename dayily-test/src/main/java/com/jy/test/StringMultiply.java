package com.jy.test;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class StringMultiply {
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int jiwei = 0;
        String total = "0";
        StringBuilder oneZero = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int tmp = a * b + jiwei;
                jiwei = tmp / 10;
                stringBuilder.append(tmp % 10);
            }
            if (jiwei > 0) {
                stringBuilder.append(jiwei);
                jiwei = 0;
            }
            total = addString(total, stringBuilder.reverse().append(oneZero).toString());
            oneZero.append(0);
        }
        return total;
    }

    private static String addString(String num1, String num2) {
        StringBuilder aaa = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int high = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = a + b + high;
            aaa.append(tmp % 10);
            high = tmp / 10;
            i--;
            j--;
        }
        if (high > 0) {
            aaa.append(high);
        }
        return aaa.reverse().toString();
    }

    public static void main(String[] args) {
        String s = multiply("1023", "456");
        System.out.println(s);
    }
}
