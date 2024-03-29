package com.jy.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongHuiWen {
    public static String longestPalindrome(String s) {
        if (0 == s.length()) {
            return "";
        }
        Map<Integer, String> map = new HashMap<>();
        int maxLength = 0;
        if (s.length() > 0) {
            maxLength = 1;
            map.put(maxLength, s.substring(0, 1));
        }
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = s.length() - 1;
            while (left < right && right + 1 - left > maxLength) {
                String tmp = s.substring(left, right + 1);
                if (isHuiWen(tmp)) {
                    maxLength = (maxLength > right + 1 - left) ? maxLength : right + 1 - left;
                    map.put(right + 1 - left, tmp);
                    break;
                } else {
                    right--;
                }
            }
        }
        return map.get(maxLength);
    }

    public static String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean isHuiWen(String s) {
        for (int i = s.length() - 1, j = 0; i > j; i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcba"));
    }
}
