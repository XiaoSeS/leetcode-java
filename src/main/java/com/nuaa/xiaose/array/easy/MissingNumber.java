package com.nuaa.xiaose.array.easy;

import java.util.Arrays;

/**
 * @Classname MissingNumber
 * @Date: 2021/10/02/ 12:31
 * @Author 萧瑟
 * @Description 0268
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class MissingNumber {

    /**
     * 标记数组的方式
     * 相同的方式 是通过HashSet 散列表
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] tag = new int[nums.length + 1];
        Arrays.fill(tag, 0);
        for (int i = 0; i < nums.length; i++) {
            tag[nums[i]] = 1;
        }
        for (int i = 0; i < tag.length; i++) {
            if (tag[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 通过位运算来求
     * 由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此我们可以通过异或运算找到缺失的数字。
     *
     * 另外的思路 通过高斯函数 减去 nums 中的数 最后得到的值就是 缺少的值
     * @param nums
     * @return
     */
    public int missingNumberS2(int[] nums) {
        int missingNumber = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }


}
