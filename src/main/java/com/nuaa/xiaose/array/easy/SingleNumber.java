package com.nuaa.xiaose.array.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname SingleNumber
 * @Date: 2021/10/01/ 20:30
 * @Author 萧瑟
 * @Description 0136
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        System.out.println((int) set.toArray()[0]);
        return 0;
    }

    /**
     * 异或运算
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

}
