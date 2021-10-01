package com.nuaa.xiaose.array.easy;

/**
 * @Classname MergeSortedArray
 * @Date: 2021/10/01/ 14:34
 * @Author 萧瑟
 * @Description 0088
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {

    /**
     * 思路:
     * 1. 先整合为一个数组, 然后对这个数组进行排序
     * 2. 我们可以使用双指针方法。将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。
     * 3. 逆向双指针
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * solve 2
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = 0, l2 = 0;
        int[] merger = new int[m + n];
        int num = 0;
        while (num != m + n) {
            if (l1 == m) {
                merger[num] = nums2[l2++];
                num++;
            } else if (l2 == n) {
                merger[num] = nums1[l1++];
                num++;
            } else if (nums1[l1] <= nums2[l2]) {
                merger[num++] = nums1[l1++];
            } else {
                merger[num++] = nums2[l2++];
            }
        }
        if (m + n >= 0) System.arraycopy(merger, 0, nums1, 0, m + n);
    }

    /**
     * solve 3
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeS3(int[] nums1, int m, int[] nums2, int n) {
        int temp = 0;
        int l1 = m - 1, l2 = n - 1;
        int index = m + n - 1;
        while (l1 >= 0 || l2 >= 0) {
            if (l1 == -1) {
                temp = nums2[l2--];
            } else if (l2 == -1) {
                temp = nums1[l1--];
            } else if (nums1[l1] > nums2[l2]) {
                temp = nums1[l1--];
            } else {
                temp = nums2[l2--];
            }
            nums1[index--] = temp;
        }
    }


}
