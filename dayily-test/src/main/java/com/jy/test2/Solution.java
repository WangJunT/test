package com.jy.test2;

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
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        l1 = reserve(l1);
        l2 = reserve(l2);
        int ten = 0;
        while (l1 != null || l2 != null) {
            int a = null == l1 ? 0 : l1.val;
            int b = null == l2 ? 0 : l2.val;
            l3.next = new ListNode((a + b + ten) % 10);
            l3 = l3.next;
            ten = (a + b) / 10;
            l1 = null == l1 ? l1 : l1.next;
            l2 = null == l2 ? l2 : l2.next;
        }
        if (ten > 0) {
            l3.next = new ListNode(ten);
        }
        return reserve(head.next);
    }

    public static ListNode reserve(ListNode listNode) {
        ListNode pre = null;
        ListNode tmp = null;
        while (listNode != null) {
            tmp = new ListNode(listNode.val);
            if (pre == null) {
                pre = new ListNode(listNode.val);
            } else {
                tmp.next = pre;
                pre = tmp;
            }
            listNode = listNode.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode lis = new ListNode(9);
        ListNode lis1 = new ListNode(9);
        lis.next = lis1;
        ListNode lasd = new ListNode(1);
        addTwoNumbers(lis,lasd);
    }
    public static void main1(String[] args) {
        //[2,4,3]
        //[5,6,4]
        ListNode lis = new ListNode(9);
        ListNode asda2 = new ListNode(1);
        ListNode asda3 = new ListNode(2);
        ListNode asda4 = new ListNode(3);
        ListNode asda5 = new ListNode(4);
        ListNode asda6 = new ListNode(5);
        ListNode asda7 = new ListNode(6);
        ListNode asda8 = new ListNode(7);
        ListNode asda9 = new ListNode(8);
        asda2.next = asda3;
        asda3.next = asda4;
        asda4.next = asda5;
        asda5.next = asda6;
        asda6.next = asda7;
        asda7.next = asda8;
        asda8.next = asda9;
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
