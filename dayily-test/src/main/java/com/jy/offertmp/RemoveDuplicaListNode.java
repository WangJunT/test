package com.jy.offertmp;


public class RemoveDuplicaListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l1 = removeDupLisNode(l1);
        System.out.println(1);
    }

    private static ListNode removeDupLisNode(ListNode head) {
        ListNode tmp = head;
        ListNode before = head;
        while (head != null) {
//            nowtmp != null &&
            if (head.val == before.val) {
                before.next = head.next;
                head = head.next;
            } else {
                before = head;
                head = head.next;
            }
        }
        return tmp;
    }
}
