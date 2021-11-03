package com.nuaa.xiaose.array.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiaose
 * @time: 2021/11/1 21:12
 * @description:- 78
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {

    private List<List<Integer>> subsets ;

    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        if (nums.length<=0) {
            return subsets;
        }
        dfs(nums,0,new LinkedList<Integer>());
        return subsets;
    }

    public void dfs(int[] nums, int start, LinkedList<Integer> list){
        subsets.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.addLast(nums[i]);
            dfs(nums,i+1,list);
            list.removeLast();
        }
    }

}
