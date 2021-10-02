package com.nuaa.xiaose.array.easy;

import java.util.HashSet;

/**
 * @author: xiaose
 * @time: 2021/10/1 23:41
 * @description: 0219
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 无法通过  我的想法: 维护一个k+1大小的活动窗口
        if (nums.length <= k+1) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < nums.length - k - 1; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i; j < i + k + 1; j++) {
                    if (!set.add(nums[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean containsNearbyDuplicateS1(int[] nums, int k) {
        // 让set 散列表 的大小维护在k
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            }
            if (set.size()>k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
