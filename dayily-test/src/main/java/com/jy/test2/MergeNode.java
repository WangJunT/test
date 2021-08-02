package com.jy.test2;

public class MergeNode {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode13 = new ListNode(13);
        ListNode listNode15 = new ListNode(15);
        ListNode listNode17 = new ListNode(17);
        ListNode listNode22 = new ListNode(22);
        listNode13.next = listNode15;
        listNode15.next = listNode17;
        listNode17.next = listNode22;


        ListNode listNode7 = new ListNode(7);
        ListNode listNode10 = new ListNode(10);
        ListNode listNode11 = new ListNode(11);
        ListNode listNode12 = new ListNode(12);
        ListNode listNode20 = new ListNode(20);
        ListNode listNode21 = new ListNode(21);
        listNode7.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode20;
        listNode20.next = listNode21;
        ListNode aaa = merge(listNode13, listNode7);
        System.out.println(1);
    }

    private static ListNode merge(ListNode listNode13, ListNode listNode7) {
        if (listNode13 == null) {
            return listNode7;
        }
        if (listNode7 == null) {
            return listNode13;
        }
        ListNode tmp = new ListNode(-1);
        ListNode head = tmp;
        while (listNode7 != null && listNode13 != null) {
            if (listNode7.val > listNode13.val) {
                head.next = new ListNode(listNode13.val);
                head = head.next;
                listNode13 = listNode13.next;
            } else {
                head.next = new ListNode(listNode7.val);
                listNode7 = listNode7.next;
                head = head.next;
            }
        }
        if (listNode7 != null ){
            head.next = listNode7;
        }
        if (listNode13 != null ){
            head.next = listNode13;
        }
        return tmp.next;
    }
}
