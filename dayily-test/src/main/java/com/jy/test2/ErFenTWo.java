package com.jy.test2;

public class ErFenTWo {
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        int m = matrix.length;
        if (0 == m) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int end = m * n;
        int begin = 0;

        int midum = 0;

        while (begin < end) {
            if (matrix[begin / m][begin % n] == target) {
                return true;
            }
            if (matrix[end / m][end % n] == target) {
                return true;
            }
            midum = (begin + end) / 2;
            int cow = midum / m;
            int lie = midum % n;
            if (matrix[cow][lie] == target) {
                return true;
            } else if (matrix[cow][lie] > target) {
                end = midum - 1;
            } else {
                begin = midum + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = new int[1][1];
        a[0] = new int[]{1};
        searchMatrix(a, 2);
        System.out.println(1);
    }
}
