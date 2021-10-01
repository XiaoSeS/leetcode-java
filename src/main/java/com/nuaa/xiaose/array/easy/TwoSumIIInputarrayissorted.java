package com.nuaa.xiaose.array.easy;

/**
 * @Classname TwoSumIIInputarrayissorted
 * @Date: 2021/10/01/ 21:15
 * @Author 萧瑟
 * @Description 0167
 * 给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumIIInputarrayissorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] ints = twoSum(numbers, 9);
    }

    /**
     * 思路:
     * 1. 二分查找
     *  遍歷對象,然後從當前位置後的第一個開始 使用二分法進行求解  space: O(nlogn)   time: O(1)
     * 2. 雙指針
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int low=0,high=numbers.length-1;
        while(low<high) {
            int sum=numbers[low]+numbers[high];
            if (sum==target) {
                return new int[]{low,high};
            }else if (sum<target) {
                low++;
            }else {
                high--;
            }
        }
        return new int[]{-1,-1};
    }
}
