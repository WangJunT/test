package com.jy.leetcode;

public class TwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int tmp = 0;
        while (l1 != null || l2 != null || tmp>0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int now = (num1 + num2 + tmp) % 10;
            tmp = (num1 + num2 + tmp) / 10;
            ListNode aa = new ListNode(now);
            head.next = aa;
            head = head.next;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        return l3.next;
    }

    public class ListNode {
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
}
