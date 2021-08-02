package com.jy.leetcode;

public class ResverseListNode {
    //反转链表前 N 个节点
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode aaaaa(ListNode head, int n) {
        ListNode newHead = head;
        ListNode tmp = head;
        ListNode listNode = reverseN(head, n);
//        newHead.next = tmp;
        return listNode;
    }
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1 || head.next == null) {
//            if (head.next == null) {
//                tmp = null;
//            } else {
//                tmp = head.next;
//            }
            return head;
        }
        ListNode lastNode = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode reverse = aaaaa(l1,2);
        System.out.println(1);
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
