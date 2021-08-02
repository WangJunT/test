package com.jy.test;

//递归反转链表
//https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
public class ReserveListNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode tmp = l1;
        int index = 1;
        int m = 2;
        int n = 4;
        ListNode h1 = new ListNode(-1);
        ListNode newTmp = h1;
        while (tmp.next != null) {
            if (index >= m && m <= n) {
                ListNode listNode = new ListNode(tmp.val);
                reserve(tmp, index, m, n, tmp);
            } else {
                newTmp.next = new ListNode(tmp.val);
                newTmp = newTmp.next;
            }
            tmp = tmp.next;
            index++;
        }
        System.out.println(1);
    }

    public static ListNode reserve(ListNode head, int index, int m, int n, ListNode biaoji) {
        if (head.next == null || index > n) {
            return head;
        }
        ListNode lastNode = reserve(head.next, index + 1, m, n, biaoji.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
