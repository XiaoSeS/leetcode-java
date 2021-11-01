package com.nuaa.xiaose.array.medium;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author: xiaose
 * @time: 2021/10/2 0:06
 * @description: 0220
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsDuplicateIII {

    /**
     * TreeSet简介
     * TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。它继承于AbstractSet抽象类，实现了NavigableSet<E>, Cloneable, java.io.Serializable接口。
     * TreeSet 继承于AbstractSet，所以它是一个Set集合，具有Set的属性和方法。
     * TreeSet 实现了NavigableSet接口，意味着它支持一系列的导航方法。比如查找与指定目标最匹配项。
     * TreeSet 实现了Cloneable接口，意味着它能被克隆。
     * TreeSet 实现了java.io.Serializable接口，意味着它支持序列化。
     * TreeSet是基于TreeMap实现的。TreeSet中的元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序。这取决于使用的构造方法。
     * TreeSet为基本操作（add、remove 和 contains）提供受保证的 log(n) 时间开销。
     * 另外，TreeSet是非同步的。 它的iterator 方法返回的迭代器是fail-fast的。
     * <p>
     * 几个api函数挺关键的
     * https://blog.csdn.net/a1439775520/article/details/95373610
     * <p>
     * <p>
     * 思路: 滑动窗口 + 有序集合
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 思路: 桶
     * 利用桶排序的思想解决问题
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicateS2(int[] nums, int k, int t) {
        return false;
    }
}
