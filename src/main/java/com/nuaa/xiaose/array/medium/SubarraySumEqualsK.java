package com.nuaa.xiaose.array.medium;

import java.util.HashMap;

/**
 * @author: xiaose
 * @time: 2021/11/2 22:11
 * @description: 560
 */
public class SubarraySumEqualsK {

    /**
     * 枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + HashMap
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] presums = new int[nums.length + 1];
//        presums[0] = 0;
//        for (int i = 0; i < nums.length; i++) {
//            presums[i + 1] = presums[i] + nums[i];
//        }
        map.put(0, 1);

        int presum = 0;
        int count = 0;
        for (int num : nums) {
            presum += num;
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
