package com.jy.test;

public class SolutionA {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        boolean asd = false;
        ListNode tmp = null;
        for (; l1 != null || l2 != null; ) {
            if (null == l3) {
                int a = l1.val + l2.val;
                if (a > 10) {
                    asd = true;
                }
                l3 = new ListNode(a % 10);
                tmp = l3;
            } else {
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                int a = 0;
                if (asd) {
                    a = 1;
                    asd = false;
                }
                if (l1 != null) {
                    a += l1.val;
                }
                if (l2 != null) {
                    a += l2.val;
                }
                if (a >= 10) {
                    asd = true;
                }
                tmp.next = new ListNode(a % 10);
            }
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode lis = new ListNode(5);
        ListNode lis1 = new ListNode(5);
//        ListNode lis2 = new ListNode(3);
//        lis.next = lis1;
//        lis1.next = lis2;
//        ListNode asda2  = new ListNode(5);
//         ListNode asda3  = new  ListNode(6);
//         ListNode asda4  = new  ListNode(4);
//         ListNode asda5  = new  ListNode(9);
//         ListNode asda6  = new  ListNode(9);
//         ListNode asda7  = new  ListNode(9);
//         ListNode asda8  = new  ListNode(9);
//         ListNode asda9  = new  ListNode(9);
//         ListNode asda10  = new  ListNode(9);
//         ListNode asda11  = new  ListNode(9);
//        asda2.next = asda3;
//        asda3.next = asda4;
//        asda4.next = asda5;
//        asda5.next = asda6;
//        asda6.next = asda7;
//        asda7.next = asda8;
//        asda8.next = asda9;
//        asda9.next = asda10;
//        asda10.next = asda11;
        addTwoNumbers(lis, lis1);
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
