package com.nuaa.xiaose.array.easy;

/**
 * @Classname RemoveElement
 * @Date: 2021/10/01/ 15:16
 * @Author 萧瑟
 * @Description 0027
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 2, 3};
        removeElement(num,3);
        System.out.println("ddd");
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }
}
