package com.jy.dongtaiguihua;

import java.util.ArrayList;
import java.util.List;
//皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
public class NQueue {
    public static List<List<String>> solveNqueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] chars = {{'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}};
        digui(chars, 0, n, lists);
        return lists;
    }

    /**
     * @param chars
     * @param row   行
     * @param n
     * @param lists
     */
    private static void digui(char[][] chars, int row, int n, List<List<String>> lists) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < chars.length; j++) {
                list.add(new String(chars[j]));
            }
            lists.add(list);
            return;
        }
        for (int lie = 0; lie < n; lie++) {
            if (!isVild(row, lie, n, chars)) {
                continue;
            }
            chars[row][lie] = 'N';
            digui(chars, row + 1, n, lists);
            chars[row][lie] = '.';
        }
    }

    private static boolean isVild(int row, int lie, int n, char[][] chars) {
        //确保所在行 所在列没有 皇后
        for (int i = 0; i < n; i++) {
            if (chars[row][i] == 'N' || chars[i][lie] == 'N')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = lie + 1;
             i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'N')
                return false;
        }
        // 检查左下方是否有皇后互相冲突
        for (int i = row - 1, j = lie - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'N')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] chars = {{'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}};
//        System.out.println(chars[0][0] == '.');
        List<List<String>> lists = solveNqueens(4);
        System.out.println(1);
    }
}
