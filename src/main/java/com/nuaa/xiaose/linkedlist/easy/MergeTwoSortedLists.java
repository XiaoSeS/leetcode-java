package com.nuaa.xiaose.linkedlist.easy;

/**
 * @Classname MergeTwoSortedLists
 * @Date: 2021/10/04/ 11:54
 * @Author 萧瑟
 * @Description 0021
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

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
        ListNode head = new ListNode();
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                node.next = null;
            } else if (l1.val < l2.val) {
                node.next=l1;
                node=node.next;
                l1=l1.next;
                node.next=null;
            } else {
                node.next=l2;
                node=node.next;
                l2=l2.next;
                node.next=null;
            }
        }
        if (l1!=null) {
            node.next=l1;
        }else {
            node.next=l2;
        }
        return head.next;
    }
}
