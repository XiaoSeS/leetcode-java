package com.nuaa.xiaose.linkedlist.easy;

/**
 * @Classname RemoveDuplicatesfromSortedList
 * @Date: 2021/10/04/ 12:10
 * @Author 萧瑟
 * @Description 0083
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class RemoveDuplicatesfromSortedList {

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return head;
        }
        ListNode pre= head;
        ListNode cur=head.next;
        while (cur!=null) {
            if (cur.val==pre.val) {
                cur=cur.next;
                pre.next=cur;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
