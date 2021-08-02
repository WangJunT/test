package com.jy.leetcode;

public class Timu148 {

    
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    static class Solution {
        public static ListNode sortList(ListNode head) {
            if(head == null || head.next==null) {
                return head;
            }
            ListNode quick = head.next;
            ListNode slow = head;
            while(quick!=null && quick.next!=null) {
                quick = quick.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            ListNode list1 = sortList(head);
            ListNode list2 = sortList(mid);
            ListNode totalHead = new ListNode(0);
            ListNode newHead = totalHead;
            while(list1!=null && list2 !=null) {
                if(list1.val>list2.val) {
                    totalHead.next = list2;
                    list2 = list2.next;
                } else {
                    totalHead.next = list1;
                    list1 = list1.next;
                }
                totalHead = totalHead.next;
            }
            if(list1 == null) {
                totalHead.next = list2;
            } else{
                totalHead.next = list1;
            }
            return newHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next =l2;
        l2.next =l3;
        l3.next =l4;
        ListNode m = Solution.sortList(l1);
        System.out.println(1);
    }
}


