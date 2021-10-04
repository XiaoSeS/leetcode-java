package com.nuaa.xiaose.linkedlist.medium;

import com.nuaa.xiaose.linkedlist.easy.LinkedListCycle;

import java.util.HashMap;

/**
 * @Classname LinkedListCycleII
 * @Date: 2021/10/04/ 19:44
 * @Author 萧瑟
 * @Description 0142
 *
 * 给定一个链表，返回链表开始入环的第一个节点。  如果链表无环，则返回  null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        HashMap<ListNode,Integer> map=new HashMap<>();
        while (head!=null) {
            if (map.containsKey(head)) {
                return head;
            }
            map.putIfAbsent(head,0);
            head=head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycleS1(ListNode head) {
        if (head==null|| head.next==null) {
            return null;
        }
        ListNode fast= head;
        ListNode slow=head;
        while (fast!=null) {
            slow=slow.next;
            if (fast.next!=null) {
                fast=fast.next.next;
            }else {
                return null;

            }
            if (fast==slow) {
                // 证明有环
                // slow  -> a+b 到达重合点  那么fast 行走了2*(a+b)
                // slow若再走a+b 将再次到达重合点 若走a步将到达 环的入口,所以可以额外使用一个指针p 从head开始 走a步 当slow和p重合时
                // 代表到达了环的入口
                ListNode p= head;
                while (p!=slow) {
                    p=p.next;
                    slow=slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
