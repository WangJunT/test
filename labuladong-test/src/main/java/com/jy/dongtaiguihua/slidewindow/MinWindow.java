package com.jy.dongtaiguihua.slidewindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/minimum-window-substring/submissions/
public class MinWindow {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c
                : t.toCharArray()) {
            Integer orDefault = need.getOrDefault(c, 0);
            need.put(c, ++orDefault);
        }
        int left = 0;
        int right = 0;
        //校验是否可以开始移动左窗口
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int len = -1;
        String result = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                Integer orDefault = window.getOrDefault(c, 0);
                window.put(c, ++orDefault);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //注意这里，已经加一了，所以下面的截取不用加一
            right++;
            while (valid == need.size()) {
                if (len == -1 || (right - left) < len) {
                    result = s.substring(left, right);
                    len = right - left;
                }
                char leftC = s.charAt(left);
                if (need.containsKey(leftC)) {
                    if (window.get(leftC).equals(need.get(leftC))) {
                        valid--;
                    }
                    Integer integer = window.get(leftC);
                    if (integer > 1) {
                        window.put(leftC, --integer);
                    } else {
                        window.remove(leftC);
                    }
                }
                left++;
            }
        }
        return result;
    }

    public String minWindow1(String s, String t) {
        //存储目标字符的hash表
        Map<Character, Integer> need = new HashMap();
        for (Character character : t.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap();
        //左窗口
        int left = 0;
        //右窗口
        int right = 0;
        //window中是否包含了目标字符中所有字符
        int valid = 0;
        //满足覆盖的开始索引
        int begin = 0;
        //满足覆盖的子串长度
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            //如果遍历到的字符存在
            if (need.containsKey(c)) {
                Integer orDefault = window.getOrDefault(c, 0);
                window.put(c, ++orDefault);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    // 进行窗口内数据的一系列更新
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    Integer aa = window.get(leftChar);
                    if (aa > 1) {
                        window.put(leftChar, --aa);
                    } else {
                        window.remove(leftChar);
                    }
                    // 在这里更新最小覆盖子串
                    if (length > (right - left)) {
                        begin = left;
                        length = right - left;
                    }
                }
                left++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(begin, begin + length);
        }
    }

    private static boolean windowContainNeed(Map<Character, Integer> window, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
    //自己想的
//    public String minWindow(String s, String t) {
//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
//        for (Character c
//                : t.toCharArray()) {
//            Integer orDefault = need.getOrDefault(c, 0);
//            need.put(c, ++orDefault);
//        }
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        String result = "";
//        while (right < s.length()) {
//            Integer orDefault = window.getOrDefault(s.charAt(right), 0);
//            window.put(s.charAt(right), ++orDefault);
//            while (windowContainNeed(window, need)) {
//                if (valid == 0) {
//                    result = s.substring(left, right + 1);
//                    valid = right - left;
//                } else if ((right - left) < valid) {
//                    result = s.substring(left, right + 1);
//                    valid = right - left;
//                }
//                Integer integer = window.getOrDefault(s.charAt(left), 0);
//                if (integer > 1) {
//                    window.put(s.charAt(left), --integer);
//                } else {
//                    window.remove(s.charAt(left));
//                }
//                left++;
//            }
//            right++;
//        }
//        return result;
//    }
//
//    private boolean windowContainNeed(Map<Character, Integer> window, Map<Character, Integer> need) {
//        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
//            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
//                return false;
//            }
//        }
//        return true;
//    }
}
