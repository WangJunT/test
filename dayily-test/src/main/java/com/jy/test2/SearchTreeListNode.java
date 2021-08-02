package com.jy.test2;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTreeListNode {

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode prev;
        BinaryTreeNode next;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode l1 = new BinaryTreeNode(6);
        BinaryTreeNode l2 = new BinaryTreeNode(14);
        BinaryTreeNode l3 = new BinaryTreeNode(4);
        BinaryTreeNode l4 = new BinaryTreeNode(8);
        BinaryTreeNode l5 = new BinaryTreeNode(12);
        BinaryTreeNode l6 = new BinaryTreeNode(16);
        root.prev = l1;
        root.next = l2;
        l1.prev = l3;
        l1.next = l4;

        l2.prev = l5;
        l2.next = l6;
        BinaryTreeNode last = null;
        last = travelBinaryNode(root, last);
        System.out.println(1);
    }

    private static BinaryTreeNode travelBinaryNode(BinaryTreeNode root, BinaryTreeNode last) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root;
        if (current.prev != null) {
            last = travelBinaryNode(current.prev, last);
        }
        current.prev = last;
        if (last != null) {
            last.next = current;
        }
        last = current;
        if (current.next != null) {
            travelBinaryNode(current.next, last);
        }
        return last;
    }

}
