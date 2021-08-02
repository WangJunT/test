package com.jy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String sa : strs) {
            String skey = sortString(sa);
            if (map.containsKey(skey)) {
                map.get(skey).add(sa);
            } else {
                List<String> list = new ArrayList<>();
                list.add(sa);
                map.put(skey, list);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            l.add((List<String>) entry.getValue());
        }
        return l;
    }

    private String sortString(String sa) {
        char[] chars = sa.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i - 1]) {
                char tmp = chars[i];
                int j = i - 1;
                while (tmp < chars[j] && j >= 0) {
                    chars[j + 1] = chars[j];
                    j--;
                }
                chars[j + 1] = tmp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b'};
        String s = new String(chars);
        System.out.println(s);
    }
}
