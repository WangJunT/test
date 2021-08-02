package com.jy.test;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                for (int j = i; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] > nums[k]) {
                            int tmp = nums[j];
                            nums[j] = nums[k];
                            nums[k] = tmp;
                        }
                    }
                }
                return;
            }
        }
        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0 && i < j; i++, j--) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2};
        nextPermutation(a);
    }

    public static void nextPermutation2(int[] nums) {
        int index = -1;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (index == -1 || nums[j] > nums[index]) {
                        flag = false;
                        index = j;
                    }
                }
            }
        }
        if (!flag) {
            int tmp = nums[index];
            nums[index] = nums[index - 1];
            nums[index - 1] = tmp;
            for (int k = index; k < nums.length; k++) {
                for (int m = k + 1; m < nums.length; m++) {
                    if (nums[k] > nums[m]) {
                        int tmp1 = nums[k];
                        nums[k] = nums[m];
                        nums[m] = tmp1;
                    }
                }
            }
            return;
        }
        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0 && i < j; i++, j--) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}
