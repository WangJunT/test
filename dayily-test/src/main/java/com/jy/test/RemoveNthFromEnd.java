package com.jy.test;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode t = head;
        int i = 1;
        map.put(i, head);
        while (head.next != null) {
            map.put(i++, head = head.next);
        }
        int k = map.size() - n + 1;
        ListNode tmp = map.get(k);
        if (t.val == tmp.val) {
            return t.next;
        }
        while (t.next != null) {
            ListNode tma = t.next;
            if (tma.val == tmp.val) {
                t.next = tma.next;
                break;
            }
            t = t.next;
        }
        return t;
    }
}
