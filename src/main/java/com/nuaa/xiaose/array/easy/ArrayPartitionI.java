package com.nuaa.xiaose.array.easy;

import java.util.Arrays;

/**
 * @Classname ArrayPartitionI
 * @Date: 2021/10/02/ 13:41
 * @Author 萧瑟
 * @Description 0561
 * <p>
 * <p>
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayPartitionI {

    /**
     * 小的和小的 组队
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
