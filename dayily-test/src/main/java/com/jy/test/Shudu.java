package com.jy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class Shudu {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Character>> hang = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            List<Character> lie = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (lie.contains(board[i][j])) {
                        return false;
                    }
                    lie.add(board[i][j]);
                    if (!hang.containsKey(j)) {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(board[i][j]);
                        hang.put(j, characterList);
                    } else {
                        if (hang.get(j).contains(board[i][j])) {
                            return false;
                        }
                        hang.get(j).add(board[i][j]);
                    }
                }
                if (j % 3 == 0 && i % 3 == 0) {
                    List<Character> xiaofangge = new ArrayList<>();
                    for (int i1 = i; i1 < i + 3; i1++) {
                        for (int j1 = j; j1 < j + 3; j1++) {
                            if (board[i1][j1] != '.') {
                                if (xiaofangge.contains(board[i1][j1])) {
                                    return false;
                                }
                                xiaofangge.add(board[i1][j1]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
