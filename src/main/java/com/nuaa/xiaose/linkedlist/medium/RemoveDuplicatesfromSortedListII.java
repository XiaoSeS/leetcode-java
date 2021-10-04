package com.nuaa.xiaose.linkedlist.medium;

import com.nuaa.xiaose.linkedlist.easy.RemoveDuplicatesfromSortedList;

import java.util.HashMap;

/**
 * @Classname RemoveDuplicatesfromSortedListII
 * @Date: 2021/10/04/ 12:10
 * @Author 萧瑟
 * @Description 0082
 * 删除排序链表中的重复元素 II
 */
public class RemoveDuplicatesfromSortedListII {
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
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int num = cur.next.val;
                while (cur.next != null && cur.next.val == num) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesS1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (next.val == head.val) {
            while (next.next != null && next.next.val == head.val) {
                next = next.next;
            }

            head = deleteDuplicatesS1(next);
        } else {
            head.next = deleteDuplicatesS1(next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(2,new ListNode(2,null));
        deleteDuplicatesS2(head);
    }

    /**
     * 计数 遍历实现
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesS2(ListNode head) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ListNode cur=head;
        while(cur!=null) {
            Integer i = map.getOrDefault(cur.val, 0);
            map.put(cur.val,i+1);
            cur=cur.next;
        }
        ListNode dummy = new ListNode(0,null);
        ListNode pre= dummy;
        cur=head;
        while (cur!=null) {
            if (map.containsKey(cur.val) && map.get(cur.val) >1) {
                cur=cur.next;
            }else {
                pre.next=cur;
                pre=pre.next;
                cur=cur.next;
                pre.next=null;
            }
        }
        return dummy.next;
    }

}
