package com.nuaa.xiaose.linkedlist.medium;

/**
 * @Classname ReverseLinkedListII
 * @Date: 2021/10/04/ 15:39
 * @Author 萧瑟
 * @Description 0092
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedListII {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre= dummy;
        for (int i = 1; i < left; i++) {
            pre=pre.next;
        }
        head = pre.next;
        for (int i = left; i < right; i++) {
            ListNode next= head.next;
            head.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummy.next;

        
    }
}
