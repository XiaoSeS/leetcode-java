package com.nuaa.xiaose.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiaose
 * @time: 2021/11/1 22:02
 * @description: 39
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {


    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        if (candidates.length<=0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates,0,0,target,new LinkedList<Integer>());
        return result;
    }

    public void dfs(int[] candidates, int start, int sum, int target, LinkedList<Integer> list){
        if (sum>target) {
            return;
        }
        if (sum==target) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            list.addLast(candidates[i]);
            dfs(candidates,i,sum+candidates[i],target,list);
            list.removeLast();
        }
    }
}
