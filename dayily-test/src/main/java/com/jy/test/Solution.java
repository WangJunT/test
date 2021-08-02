package com.jy.test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        long num1 = l1.val;
        long num2 = l2.val;
        ListNode l1next;
        ListNode l2next;
        for (int i = 1;(l1next = l1.next) != null; i++) {
            num1 += l1next.val * Math.pow(10,i);
            l1 = l1.next;
        }
        for (int i = 1; (l2next = l2.next) != null; i++ ) {
            num2 += l2next.val  * Math.pow(10,i);
            l2 = l2.next;
        }
        long num3 = num1 + num2;
        if (num3 == 0) {
            l3 = new ListNode(0);
            return l3;
        }
        ListNode tmp = null;
        for (; num3 != 0; ) {
            if (null == l3) {
                tmp = new ListNode((int) (num3 % 10));
                l3 = tmp;
            } else {
                while(tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new ListNode((int) (num3 % 10));
            }
            num3 = num3 / 10;
        }
        return l3;
    }

    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
        ListNode lis = new ListNode(9);
        ListNode asda2  = new ListNode(1);
        ListNode asda3  = new ListNode(9);
        ListNode asda4  = new ListNode(9);
        ListNode asda5  = new ListNode(9);
        ListNode asda6  = new ListNode(9);
        ListNode asda7  = new ListNode(9);
        ListNode asda8  = new ListNode(9);
        ListNode asda9  = new ListNode(9);
        ListNode asda10  = new ListNode(9);
        ListNode asda11  = new ListNode(9);
        asda2.next = asda3;
        asda3.next = asda4;
        asda4.next = asda5;
        asda5.next = asda6;
        asda6.next = asda7;
        asda7.next = asda8;
        asda8.next = asda9;
        asda9.next = asda10;
        asda10.next = asda11;
        addTwoNumbers(lis,asda2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
