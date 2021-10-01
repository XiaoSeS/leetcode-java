package com.nuaa.xiaose.array.easy;

/**
 * @Classname ConvertSortedArraytoBinarySearchTree
 * @Date: 2021/10/01/ 16:44
 * @Author 萧瑟
 * @Description 0108
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertSortedArraytoBinarySearchTree {


    /**
     * Definition for a binary tree node.
     * 二叉搜索树是一种节点值之间具有一定数量级次序的二叉树，对于树中每个节点：
     *
     * 若其左子树存在，则其左子树中每个节点的值都不大于该节点值；
     * 若其右子树存在，则其右子树中每个节点的值都不小于该节点值。
     *
     * 二叉树的中序遍历是升序序列
     *
     * 平衡二叉树
     */
    public static class TreeNode {
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

    public static void main(String[] args) {

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        // 递归结束的条件
        if (left>right) {
            return null;
        }
        // 取中间值
        int mid = (left+right)/2;
        // 分别递归调用
        TreeNode root =new TreeNode(nums[mid]);
        TreeNode l = helper(nums, left, mid-1);
        TreeNode r = helper(nums, mid + 1, right);
        root.left=l;
        root.right=r;
        return root;
    }
}
