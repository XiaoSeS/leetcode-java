package com.nuaa.xiaose.linkedlist.medium;

/**
 * @Classname PartitionList
 * @Date: 2021/10/04/ 15:22
 * @Author 萧瑟
 * @Description 0086
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {

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

    public ListNode partition(ListNode head, int x) {
        ListNode small =new ListNode(0);
        ListNode s=new ListNode();
        ListNode large =new ListNode(0);
        ListNode l=new ListNode();
        s=small;
        l=large;
        while (head!=null) {
            if (head.val<x) {
                s.next=head;
                s=s.next;
            }else {
                l.next=head;
                l=l.next;
            }
            head=head.next;
        }
        s.next=large.next;
        l.next=null;
        return small.next;
    }
}
