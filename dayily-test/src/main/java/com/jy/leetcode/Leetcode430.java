package com.jy.leetcode;

public class Leetcode430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);
//        Node n8 = new Node(8);
//        Node n9 = new Node(9);
//        Node n10 = new Node(10);
//        Node n11 = new Node(11);
//        Node n12 = new Node(12);
//        n1.next = n2;
//        n2.prev = n1;
//        n2.next = n3;
//        n3.prev = n2;
//        n3.next = n4;
//        n4.prev = n3;
//        n4.next = n5;
//        n5.prev = n4;
//        n5.next = n6;
//        n6.prev = n5;
//        n3.child = n7;
//        n7.next = n8;
//        n8.prev = n7;
//        n8.next = n9;
//        n9.prev = n8;
//        n9.next = n10;
//        n10.prev = n9;
//        n8.child = n11;
//        n11.next = n12;
//        n12.prev = n11;
        n1.child = n2;
        n2.child = n3;
        flatten(n1);
        System.out.println(1);
    }

    public static Node flatten(Node head) {
        Node really = head;
        while (head != null) {
            if (head.child != null) {
                Node headnext = head.next;
                Node hebing = hebing(head, head.child);
                if (headnext != null) {
                    hebing.next = headnext;
                    headnext.prev = hebing;
                }
                head = headnext;
            } else {
                head = head.next;
            }
        }
        return really;
    }

    private static Node hebing(Node head, Node child) {
        Node pre = child;
        child.prev = head;
        head.child = null;
        head.next = child;
        while (child != null) {
            pre = child;
            if (child.child != null) {
                Node headnext = child.next;
                Node hebing = hebing(child, child.child);
                if (headnext != null) {
                    hebing.next = headnext;
                    headnext.prev = hebing;
                } else{
                    pre = hebing;
                }
                child = headnext;
            } else {
                child = child.next;
            }
        }
        return pre;
    }
}
//        if (next != null) {
//            pre.next = next;
//            next.prev = pre;
//        }
