package com.nuaa.xiaose.array.easy;

/**
 * !!! 比较重要的一道题
 *
 * @Classname MaximumSubarray
 * @Date: 2021/10/01/ 15:34
 * @Author 萧瑟
 * @Description 0053
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray {
    /**
     * 思路:
     * 1. 动态规划 f(i)=max{f(i−1)+nums[i],nums[i]}
     * 2. 贪心算法
     * 3. 线段树 分治法
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 动态规划 主要想到动态规划转移方程
     *
     * @param nums
     * @return
     */
    public int maxSubArrayS1(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }


    /**
     * O(n) 应该就能解决了
     * 贪心算法
     *
     * @param nums 至少包含一个元素
     * @return
     */
    public int maxSubArrayS2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static class Status {
        /**
         * lSum 表示 [l,r][l,r] 内以 ll 为左端点的最大子段和
         * {rSum}rSum 表示 [l,r][l,r] 内以 rr 为右端点的最大子段和
         * {mSum}mSum 表示 [l,r][l,r] 内的最大子段和
         * {iSum}iSum 表示 [l,r][l,r] 的区间和
         */
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }


    /**
     * 分治法 线段树
     * <p>
     * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayS3(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private static Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(nums, l, m);
        Status rSub = getInfo(nums, m + 1, r);

        return pushUp(lSub, rSub);
    }

    private static Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


}
