package com.nuaa.xiaose.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaose
 * @time: 2021/11/2 20:54
 * @description: 713
 * 思路:
 * 1. 递归 + 回溯
 * 2. 双指针
 * 3. 二分法
 */
public class SubarrayProductLessThanK {

//    private List<List<Integer>> result;

    private int number;

    /**
     * 递归回溯 会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        number = 0;
        if (nums.length <= 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, 1, k);
        }
        return number;
    }

    void dfs(int[] nums, int start, int product, int k) {
        int i = start;
        if (i + 1 > nums.length) {
            return;
        }
        product = product * nums[i];
        if (product >= k) {
            return;
        }
        number++;
        dfs(nums, i + 1, product, k);
    }

    /**
     * 二分法
     * <p>
     * 使用取对数 log 来防止数值溢出
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        // 没弄明白
        // 因为，浮点数的运算精度有限存在误差，因此必须使用误差小于某个预先给定值的方法来做。
        return 0;
    }

    /**
     * 双指针
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int product = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
