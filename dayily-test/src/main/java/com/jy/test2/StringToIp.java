package com.jy.test2;

import java.util.ArrayList;
import java.util.List;

public class StringToIp {
    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);
        System.out.println(1);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return list;
        }
        digui(s, 0, list, new StringBuilder(), 0);
        return list;
    }

    private static void digui(String s, int index, List<String> list, StringBuilder sb, int dep) {
        if (dep >= 4 || index >= s.length()) {
            if (index >= s.length() && dep >= 4) {
                list.add(sb.toString());
            }
            return;
        }
        if (s.length() - index > (4 - dep) * 3 || s.length() - index < (4 - dep) * 1) {
            return;
        }
        int tmp = Integer.valueOf(s.substring(index, index + 1));
        StringBuilder sbTmp = new StringBuilder(sb.toString());
        sbTmp.append(tmp);
        if (dep < 3) {
            sbTmp.append(".");
        }
        digui(s, index + 1, list, sbTmp, dep + 1);
        if (tmp != 0) {
            if (index + 2 <= s.length()) {
                int tmpaa = Integer.valueOf(s.substring(index, index + 2));
                StringBuilder sbTmpa = new StringBuilder(sb.toString());
                sbTmpa.append(tmpaa);
                if (dep < 3) {
                    sbTmpa.append(".");
                }
                digui(s, index + 2, list, sbTmpa, dep + 1);
            }
            if (index + 3 <= s.length()) {
                int tmpaa = Integer.valueOf(s.substring(index, index + 3));
                if (tmpaa <= 255) {
                    StringBuilder sbTmpa = new StringBuilder(sb.toString());
                    sbTmpa.append(tmpaa);
                    if (dep < 3) {
                        sbTmpa.append(".");
                    }
                    digui(s, index + 3, list, sbTmpa, dep + 1);
                }
            }
        }
    }
}
