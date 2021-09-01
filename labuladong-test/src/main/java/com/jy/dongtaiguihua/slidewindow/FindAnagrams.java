package com.jy.dongtaiguihua.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指字母相同，但排列不同的字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> need = new HashMap();
        for (Character character : p.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap();
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                Integer orDefault = window.getOrDefault(c, 0);
                window.put(c, ++orDefault);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (valid == need.size()) {
                char leftChar = s.charAt(left);
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
                    if (s.length() == (right - left)) {
                        list.add(left);
                    }
                }
                left++;
            }
        }
        return  list;
    }
}
