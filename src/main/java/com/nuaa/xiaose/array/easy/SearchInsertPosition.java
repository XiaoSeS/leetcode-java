package com.nuaa.xiaose.array.easy;

/**
 * @Classname SearchInsertPosition
 * @Date: 2021/10/01/ 14:04
 * @Author 萧瑟
 * @Description 0035
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    /**
     * 二分查找
     * 我写的
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left= 0;
        int right= nums.length-1;
        while (left <= right) {
//            int middle= (left+right)/2;
            int middle = ((right - left) >> 1) + left;
            if (nums[middle]==target) {
                return middle;
            }else if (nums[middle]>target) {
                // 再左侧
                right=middle-1;
            }else {
                // 再右侧
                left=middle+1;
            }
        }
        return left;
    }

    /***
     * 官方答案
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsertLeetCode(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
