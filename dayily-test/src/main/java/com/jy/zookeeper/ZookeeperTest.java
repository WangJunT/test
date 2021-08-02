package com.jy.zookeeper;

public class ZookeeperTest {
    public static void main(String[] args) {
//        Zookeeper zookeeper = new Zookeeper();
        String s = "asdsa";
        System.out.println(isHui(s));
    }

    private static boolean isHui(String s) {
        int len = s.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
