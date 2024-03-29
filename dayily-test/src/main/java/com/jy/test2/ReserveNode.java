package com.jy.test2;

public class ReserveNode {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode aaa = reserve(listNode1);
        System.out.println(1);
    }

    private static ListNode reserve(ListNode listNode1) {
        if (listNode1 == null || listNode1.next == null) {
            return listNode1;
        }
        ListNode head = reserve(listNode1.next);
        listNode1.next.next = listNode1;
        listNode1.next = null;
        return head;
    }
}
