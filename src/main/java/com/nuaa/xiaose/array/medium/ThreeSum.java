package com.nuaa.xiaose.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ThreeSum
 * @Date: 2021/10/04/ 11:10
 * @Author 萧瑟
 * @Description 0015
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

    }

    /**
     * 思路: 排序 + 双指针
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int curr = nums[i];
            int l = i + 1, r = len - 1;
            while (l < r) {
                int temp = curr + nums[l] + nums[r];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (temp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
