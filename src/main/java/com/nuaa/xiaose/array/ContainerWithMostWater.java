package com.nuaa.xiaose.array;

/**
 * @author: xiaose
 * @time: 2021/10/1 11:48
 * @description:- 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }

    /**
     * 思路:
     * 1. 两个for循环吧
     * 2. 双指针
     * 当前方法是双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left, right;
        left = 1;
        right = height.length;
        int max = 0;
        int product = 0;
        while (left < right) {
            if (height[left - 1] <= height[right - 1]) {
                product = height[left - 1] * (right - left);
                left++;
            } else {
                product = height[right - 1] * (right - left);
                right--;
            }
            if (max < product) {
                max = product;
            }
        }
        return max;
    }
}
