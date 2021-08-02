package com.jy.test;

public class HuiWenCount {
    public static int countSubstrings(String s) {
        int count = 0;
        boolean[][] db = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            count++;
            db[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) != s.charAt(i)) {
                    db[i][j] = false;
                } else {
                    if (j - i < 3) {
                        db[i][j] = true;
                    } else {
                        db[i][j] = db[i + 1][j - 1];
                    }
                }
                if (db[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
