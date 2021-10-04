package com.nuaa.xiaose.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CopyListwithRandomPointer
 * @Date: 2021/10/04/ 16:11
 * @Author 萧瑟
 * @Description 0138
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的  深拷贝。  深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由  n  个节点组成的链表来表示输入/输出中的链表。每个节点用一个  [val, random_index]  表示：
 * <p>
 * val：一个表示  Node.val  的整数。
 * random_index：随机指针指向的节点索引（范围从  0  到  n-1）；如果不指向任何节点，则为    null  。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyListwithRandomPointer {


    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     *  使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // map方法，空间复杂度O(n)
        Node node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<Node,Node> map = new HashMap<>();
        while(node != null){
            Node clone = new Node(node.val);
            map.put(node,clone);
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     * 方法一：回溯 + 哈希表
     * @param head
     * @return
     */
    public Node copyRandomListS1 (Node head) {
        if (head==null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newNode= new Node(head.val);
            cachedNode.put(head,newNode);
            newNode.next = copyRandomListS1(head.next);
            newNode.random = copyRandomListS1(head.random);
        }
        return cachedNode.get(head);
    }

}
