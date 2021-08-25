package com.jy.dongtaiguihua.reservelist;


/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode successor = null; // 后驱节点

    // int z = 0;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        // z = n;
        ListNode tmp = head;
        if (m == 1) {
            return reserve(tmp, n - m);
        }
        int count = 1;
        ListNode before = head;
        while (count < m && tmp.next != null) {
            count++;
            before = tmp;
            tmp = tmp.next;
        }
        // z = n-m;
        before.next = reserve(tmp, n - m);
        return head;
    }

    public void sout(int as) {
        for (int i = 0; i < as; i++) {
            System.out.print(" ");
        }
    }

    public ListNode reserve(ListNode list, int n) {
        if (n <= 0) {
            successor = list.next;
            return list;
        }
        // sout(z-n);
        // System.out.println(list.val+":" + n);
        ListNode head = reserve(list.next, --n);
        list.next.next = list;
        list.next = successor;
        return head;
    }

    // 牛逼
    ListNode reverseBetween1(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reserve(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween1(head.next, m - 1, n - 1);
        return head;
    }
}
