package com.jy.leetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCode151 {

    public static void main(String[] args) {
        System.out.println(reverseWordsTwo("it is a good thing"));;
    }
    //方法1  先翻转整个字符串，在翻转单个的
    public static String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        //去除字符串首尾两端空格
        while (left <= right) {
            if (s.charAt(left) == ' ') {
                left++;
            } else if (s.charAt(right) == ' ') {
                right--;
            } else {
                break;
            }
        }
        s = s.substring(left, right + 1);
        //整个字符串翻转
        StringBuilder stringBuilder = reverseTotal(s);
        left = 0;
        right = stringBuilder.length();
        int begin = 0;
        while (left < right) {
            if (stringBuilder.charAt(left) == ' ') {
                //翻转单个的
                reaaaa(stringBuilder, begin, left);
                left++;
                begin = left;
            } else {
                left++;
            }
        }
        //最后一个单词还没处理
        reaaaa(stringBuilder, begin, right);
        return stringBuilder.toString();
    }

    private static void reaaaa(StringBuilder s, int begin, int end) {
        String re = s.substring(begin, end);
        char[] chars = new char[re.length()];
        for (int a = 0; a < chars.length; a++) {
            chars[a] = re.charAt(chars.length - 1 - a);
        }
        s.delete(begin, end);
        s.insert(begin, chars);
//        s
    }

    private static StringBuilder reverseTotal(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' || (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ')) {
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }
    //=================================================================================

    //方法三
    public static String reverseWordsTwo(String s) {
        Deque<String> deque = new LinkedBlockingDeque<>();
        int left = 0;
        int right = s.length() - 1;
        //去除字符串首尾两端空格
        while (left <= right) {
            if (s.charAt(left) == ' ') {
                left++;
            } else if (s.charAt(right) == ' ') {
                right--;
            } else {
                break;
            }
        }
        s = s.substring(left, right + 1);
        left = 0;
        right = s.length();
        int begin = 0;
        while(left <right) {
            if (s.charAt(left) == ' ' && s.charAt(left-1)!=' ') {
                deque.push(s.substring(begin,left));
                left++;
                begin=left;
            } else if (s.charAt(left) != ' ') {
                left++;
            } else {
                left++;
                begin=left;
            }
        }
        deque.push(s.substring(begin,right));
        Iterator<String> iterator = deque.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(" "+iterator.next());
        }
        stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }

}
