package com.jy.test2;

public class FindListNodeCircle {
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
        listNode6.next = listNode3;
        ListNode circle = findCircle(listNode1);
        System.out.println(1);
    }

    private static ListNode findCircle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            ListNode findCir = tmp.next;
            while (findCir != fast) {
                findCir = findCir.next;
                fast = fast.next;
            }
        }
        return fast;
    }
}
