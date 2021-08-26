package com.jy.dongtaiguihua.lianbiao.huiwen;

public class IsPalindrome {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //是偶数
        if (fast != null) {
            mid = slow.next;
        } else {
            //奇数
            mid = slow;
        }
        ListNode newNode = reserveNode(mid);
        while (newNode != null) {
            if (head.val != newNode.val) {
                return false;
            }
            head = head.next;
            newNode = newNode.next;
        }
        return true;
    }

    private static ListNode reserveNode(ListNode mid) {
        if (mid == null || mid.next == null) {
            return mid;
        }
        ListNode root = reserveNode(mid.next);
        mid.next.next = mid;
        mid.next = null;
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        isPalindrome(l1);
        System.out.println(1);
    }
}
