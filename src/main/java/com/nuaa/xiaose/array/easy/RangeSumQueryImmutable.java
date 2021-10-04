package com.nuaa.xiaose.array.easy;

/**
 * @Classname RangeSumQueryImmutable
 * @Date: 2021/10/02/ 13:00
 * @Author 萧瑟
 * @Description 0303
 */
public class RangeSumQueryImmutable {

    int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1]-sums[left];
    }

}
