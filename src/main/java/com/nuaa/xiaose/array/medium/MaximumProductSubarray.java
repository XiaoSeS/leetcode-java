package com.nuaa.xiaose.array.medium;

/**
 * @author: xiaose
 * @time: 2021/11/1 20:43
 * @description: -
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * <p>
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max=1,min=1;
        for (int num : nums) {
            if (num<0) {
                int temp = max;
                max=Math.max(min*num,num);
                min=Math.min(temp*num,num);
            }else {
                max=Math.max(num*max,num);
                min=Math.min(num*min,num);
            }
            result= Math.max(max,result);
        }
        return result;
    }
}
