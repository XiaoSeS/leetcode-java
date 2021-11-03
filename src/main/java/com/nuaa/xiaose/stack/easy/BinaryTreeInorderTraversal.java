package com.nuaa.xiaose.stack.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Classname BinaryTreeInorderTraversal
 * @Date: 2021/10/06/ 20:16
 * @Author 萧瑟
 * @Description 0094
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * 中序遍历
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 颜色标记法 ！！！
     *
     * 其核心思想如下：
     *
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     *
     * 兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalS2(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;   //初始检查
        stack.push(root);
        map.put(root,1);//1表示第一次访问 白色,2表示第二次访问。 灰色
        while (!stack.empty()){
            TreeNode pop = stack.pop();
            if (map.get(pop)==1) {
                // 白色
                //如果是第一次访问的话，则将其右子节点，自身，左子结点入栈
                //将右子节点入栈
                if (pop.right!=null) {
                    stack.push(pop.right);
                    map.put(pop.right,1);
                }

                //将自身入栈，改变访问次数
                stack.push(pop);
                map.put(pop,2);
                //将左子节点入栈
                if (pop.left!=null) {
                    stack.push(pop.left);
                    map.put(pop.left,1);
                }
            }else {
                // 灰色
                list.add(pop.val);
            }
        }
        return list;
    }

    /**
     * 递归方法遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root);
    }

    private List<Integer> inorder(TreeNode root) {

        List<Integer> order= new ArrayList<>();
        if (root==null) {
            return order;
        }
        order.addAll(inorder(root.left));
        order.add(root.val);
        order.addAll(inorder(root.right));
        return order;
    }

    /**
     * 基于栈的树中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalS1(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> order= new ArrayList<>();
        TreeNode cur=root;
        while (cur!=null || !stack.empty()) {
            if (cur!=null ) {
                stack.push(cur);
                cur=cur.left;
            }else {
                TreeNode pop = stack.pop();
                order.add(pop.val);
                cur=pop.right;
            }
        }
        return order;
    }



}
