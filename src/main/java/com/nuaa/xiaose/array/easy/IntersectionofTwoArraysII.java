package com.nuaa.xiaose.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xiaose
 * @time: 2021/10/3 21:40
 * @description: 0350
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。\
 * 
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 归并排序是天然适合外部排序的算法，可以将分割后的子数组写到单个文件中，归并时将小文件合并为更大的文件。当两个数组均排序完成生成两个大文件后，即可使用双指针遍历两个文件，如此可以使空间复杂度最低。
 */
public class IntersectionofTwoArraysII {

    /**
     * 思路:
     * 1. 集合
     * 2. hash 散列表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2)
                .boxed()
                .filter(num -> {
                    if (list1.contains(num)) {
                        list1.remove(num);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        int[] res = new int[list2.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list2.get(i);
        }
        return res;
    }

    // hashmap
    public int[] intersectS2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            int count = map1.getOrDefault(num, 0)+1;
            map1.put(num,count);
        }
        int[] res=new int[nums2.length];
        int index=0;
        for (int num : nums2) {
            int count = map1.getOrDefault(num, 0);
            if (count>0) {
                res[index]=num;
                index++;
                count--;
                if (count>0) {
                    map1.put(num,count);
                }else {
                    map1.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    // 排序 + double point
    public int[] intersectS3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1=nums1.length;
        int l2=nums2.length;
        int index1=0,index2=0,index=0;
        int[] res= new int[Math.min(l1,l2)];
        while (index1<l1 && index2<l2) {
            if (nums1[index1]<nums2[index2]) {
                index1++;
            }else if (nums1[index1]>nums2[index2]) {
                index2++;
            }else {
                res[index]=nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
