package com.nuaa.xiaose.array.easy;

/**
 * @Classname RemoveDuplicatesfromSortedArray
 * @Date: 2021/10/01/ 13:32
 * @Author 萧瑟
 * @Description 0026
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("length:"+length);

    }

    /**
     * 思路:
     *  从左到右遍历
     *  双指针的方式
     *  其中index 和 i 代表 前后指针
     *  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int num = 1;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                index++;
                nums[index] = nums[i];
                num++;
            }
        }
        return num;
    }
}
