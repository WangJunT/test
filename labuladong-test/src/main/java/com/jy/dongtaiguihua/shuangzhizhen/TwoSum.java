package com.jy.dongtaiguihua.shuangzhizhen;

/**
 * 双指针技巧：
 *      快慢指针：链表的环，链表的环的位置，删除链表第n个节点
 *      左右指针：二分查找，两数之和，反转字符
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            } else if (numbers[left] + numbers[right]  > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                 left++;
            }
        }
        int[] res = new int[2];
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }

    public static void main(String[] args) {

    }
}
