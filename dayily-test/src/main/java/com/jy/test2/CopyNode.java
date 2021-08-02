package com.jy.test2;

public class CopyNode {
    static class LinkNode {
        int val;
        LinkNode next;
        LinkNode random;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkNode root = new LinkNode(5);
        copyNode(root);
    }

    private static LinkNode copyNode(LinkNode root) {
        if (root == null) {
            return null;
        }
        LinkNode head = root;
        //先复制每个节点，并且放到原始节点的后面
        while (root != null) {
            LinkNode tmp = new LinkNode(root.val);
            tmp.next = root.next;
            root.next = tmp;
            root = tmp.next;
        }
        root = head;
        //复制随机节点
        while (root != null) {
            LinkNode pclone = root.next;
            if (root.random != null) {
                pclone.random = root.random.next;
            }
            root = pclone.next;
        }
        root = head;
        //拆分成两个节点
        LinkNode copyHead = null;
        LinkNode copyNode = null;
        if (root != null) {
            copyHead = copyNode = root.next;
            root.next = copyNode.next;
            root = root.next;
        }
        while (root != null) {
            copyNode.next = root.next;
            copyNode = root.next;
            root.next = copyNode.next;
            root = root.next;

        }
        return copyHead;
    }

}
