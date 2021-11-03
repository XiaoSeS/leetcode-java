package com.nuaa.xiaose.array.medium;

import java.util.HashSet;

/**
 * @author: xiaose
 * @time: 2021/11/1 23:00
 * @description: 128
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result=0;
        for (int num : nums) {
            if (set.contains(num)) {
                int len=1;
                int temp=num;
                while (set.contains(--temp)) {
                    len++;
                    set.remove(temp);
                }
                temp=num;
                while (set.contains(++temp)) {
                    len++;
                    set.remove(temp);
                }
                result=Math.max(result,len);
            }
        }
        return result;
    }
}
