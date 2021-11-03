package com.nuaa.xiaose.array.medium;

import java.util.*;

/**
 * @author: xiaose
 * @time: 2021/11/1 21:49
 * @description: 90
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetsII {


    private List<List<Integer>> subsets ;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        if (nums.length<=0) {
            return subsets;
        }
        Arrays.sort(nums);
        dfs(nums,0,new LinkedList<Integer>());
        return subsets;
    }

    public void dfs(int[] nums, int start, LinkedList<Integer> list){
        subsets.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i>start&&nums[i]==nums[i-1]) {
                continue;
            }
            list.addLast(nums[i]);
            dfs(nums,i+1,list);
            list.removeLast();
        }
    }
}
