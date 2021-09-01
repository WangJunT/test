package com.jy.dongtaiguihua.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class CheckInclusion {
    static List<String> list = new ArrayList<>();

    public static boolean checkInclusion(String s1, String s2) {
        //存储目标字符的hash表
        Map<Character, Integer> need = new HashMap();
        for (Character character : s1.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap();
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (need.containsKey(c)) {
                Integer orDefault = window.getOrDefault(c, 0);
                window.put(c, ++orDefault);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (valid == need.size()) {
                char leftChar = s2.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    Integer aa = window.get(leftChar);
                    if (aa > 1) {
                        window.put(leftChar, --aa);
                    } else {
                        window.remove(leftChar);
                    }
                    if (s1.length() == (right - left)) {
                        return true;
                    }
                }
                left++;
            }
        }
        return  false;
    }

    private static void quanpailie(char[] toCharArray, ArrayList<Character> characters) {
        if (characters.size() >= toCharArray.length) {
            char[] aa = new char[characters.size()];
            for (int i = 0; i < characters.size(); i++) {
                aa[i] = characters.get(i);
            }
            list.add(new String(aa));
            return;
        }
        for (int i = 0; i < toCharArray.length; i++) {
            if (characters.contains(toCharArray[i])) {
                continue;
            }
            ArrayList<Character> characters1 = new ArrayList<>(characters);
            characters1.add(toCharArray[i]);
            quanpailie(toCharArray, characters1);
        }
    }

    public static void main(String[] args) {
        checkInclusion("nasc", "asdasdasdasdasd");
    }
}
