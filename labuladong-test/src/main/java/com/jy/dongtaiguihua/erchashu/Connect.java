package com.jy.dongtaiguihua.erchashu;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (null == root) {
            return root;
        }
        Deque<Node> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            Node pop = list.pop();
            if (pop.left != null) {
                pop.left.next = pop.right;
                if (pop.next != null) {
                    pop.right.next = pop.next.left;
                }
                list.push(pop.left);
                list.push(pop.right);
            }
        }
        return root;
    }
}
