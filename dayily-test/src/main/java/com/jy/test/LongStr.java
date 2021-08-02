package com.jy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//无重复字符的最长子串
public class LongStr {
    public static int lengthOfLongestSubstring(String s) {
        List<Character> list;
        int length = s.length() > 0 ? 1 : 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            list = new ArrayList<>();
            list.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (list.contains(chars[j])) {
                    break;
                }
                list.add(chars[j]);
                if (j == chars.length - 1) {
                    return length;
                }
            }
            length = length > list.size() ? length : list.size();
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abcabca";
        lengthOfLongestSubstring2(s);
    }

    private static int lengthOfLongestSubstring2(String s) {
        int length = s.length() > 0 ? 1 : 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i],i);
            length = Math.max(length, i -left + 1);
        }
        return length;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int length = s.length() > 0 ? 1 : 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            if (i > 0 && chars[i] == chars[i - 1]) {
//                continue;
//            }
            Map<Character, Integer> map = new HashMap<>();
            map.put(chars[i], i);
            for (int j = i + 1; j < chars.length; j++) {
                if (map.containsKey(chars[j])) {
                    i = map.get(chars[j]);
                    break;
                }
                map.put(chars[j], j);
            }
            length = length > map.size() ? length : map.size();
        }
        return length;
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;//最长子串长度
//        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
//        for(int i = 0; i < s.length(); i ++){
//            if(map.containsKey(s.charAt(i))){//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
//                left = Math.max(left,map.get(s.charAt(i)) + 1);       //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
//            }        //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
//            map.put(s.charAt(i),i);      //再更新map中a映射的下标
//            max = Math.max(max,i-left+1);     //比较两个参数的大小
//        }
//        return max;
    }
}
