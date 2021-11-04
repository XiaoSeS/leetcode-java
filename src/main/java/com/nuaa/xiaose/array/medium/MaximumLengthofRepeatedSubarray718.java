package com.nuaa.xiaose.array.medium;

/**
 * @author: xiaose
 * @time: 2021/11/4 13:42
 * @description:
 */
public class MaximumLengthofRepeatedSubarray718 {

    /**
     * 动态规划求解
     * 我们希望优化这一过程，使得任意一对 A[i] 和 B[j] 都只被比较一次。这样我们自然而然想到利用这一次的比较结果。如果 A[i] == B[j]，那么我们知道 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一，否则我们知道 A[i:] 与 B[j:] 的最长公共前缀为零。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength1(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int res=0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {

                if (nums1[i-1]==nums2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res= Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *  //窗口滑动的重叠过程可以分为三个过程：
     *  //1、下面子串进入，开始重叠的过程
     *  //2、上下两子串完全重叠，中间过程
     *  //3、下面的子串开始离开，重叠区域减少，离开过程
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        return nums1.length<=nums2.length ? findMax(nums1,nums2) : findMax(nums2,nums1);
    }

    public int findMax(int[] nums1, int[] nums2) {
        int al=nums1.length;
        int bl=nums2.length;
        int result=0;
        // A不动， B依次从左到右滑动
        // 需要较短的数组不动
        //进入时候的处理
        for (int i = 1; i <= al; i++) {
            int len= maxLength(nums1,nums2,0,bl-i,i);
            result=Math.max(result,len);
        }
        //中间过程的处理
        for (int i = bl; i-al >=0 ; i--) {
            int len = maxLength(nums1,nums2,0,i-al,al);
            result=Math.max(result,len);
        }
        //出去时的处理
        for (int i = al; i >=1 ; i--) {
            int len= maxLength(nums1,nums2,al-i,0,i);
            result=Math.max(result,len);
        }
        return result;
    }

    public int maxLength(int[] A,int[] B, int addA,int addB, int len) {
        int res=0,k=0;
        for (int i = 0; i < len; i++) {
            if (A[addA+i]==B[addB+i]) {
                k++;
            }else{
                k=0;
            }
            res=Math.max(res,k);
        }
        return res;
    }
}
