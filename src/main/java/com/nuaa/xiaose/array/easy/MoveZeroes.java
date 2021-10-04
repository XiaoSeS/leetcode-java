package com.nuaa.xiaose.array.easy;

/**
 * @Classname MoveZeroes
 * @Date: 2021/10/02/ 12:44
 * @Author 萧瑟
 * @Description 0283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    /**
     * 记录零的个数 然后非零往前面移动
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int num=0;
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                num++;
            }else if (index!=i) {
                nums[index++] = nums[i];
            }else {
                index++;
            }
        }
        while (num>0) {
            nums[index++]=0;
            num--;
        }
    }
}
