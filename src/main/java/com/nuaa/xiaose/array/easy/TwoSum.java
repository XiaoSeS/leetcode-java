package com.nuaa.xiaose.array.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: xiaose
 * @time: 2021/10/1 11:07
 * @description: 0001
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums= new int[]{3,3};
        int[] result = towSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 思路:
     * 1. 遍历两次 时间复杂度n2
     * 2. 使用hashMap来解决
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer temp = target - nums[i];
            if (m.containsKey(temp)) {
                return new int[]{m.get(temp), i};
            }
            m.put(nums[i], i);
        }
        return new int[0];
    }
}
