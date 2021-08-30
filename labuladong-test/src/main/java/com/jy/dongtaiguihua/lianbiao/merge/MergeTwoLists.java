package com.jy.dongtaiguihua.lianbiao.merge;


public class MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        } else {
            tmp.next = l2;
        }
        return head.next;
    }
}
