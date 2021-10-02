package com.nuaa.xiaose.array.easy;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: xiaose
 * @time: 2021/10/1 22:29
 * @description: 0169
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 思路:
     * 1. hashmap
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> keys = map.keySet();
        int num = 0;
        for (Integer key : keys) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return num;
    }

    /**
     * 2.摩尔投票法：
     * <p>
     * 核心就是对拼消耗。
     * <p>
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     * <p>
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     * <p>
     * 最后能剩下的必定是自己人。
     *
     * @param nums
     * @return
     */
    public static int majorityElementS2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = nums[i + 1];
            }
        }
        return num;
    }

}
