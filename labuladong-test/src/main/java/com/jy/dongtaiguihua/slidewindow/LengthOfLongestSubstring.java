package com.jy.dongtaiguihua.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            right++;
            while (window.get(rightChar) > 1) {
                if (window.get(s.charAt(left)) > 1) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                } else {
                    window.remove(s.charAt(left));
                }
                left++;
            }
            if ((right - left) > maxLength) {
                maxLength = right - left;
            }
        }
        return maxLength;
    }
}
