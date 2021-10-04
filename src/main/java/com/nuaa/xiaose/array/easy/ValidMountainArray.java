package com.nuaa.xiaose.array.easy;

/**
 * @Classname ValidMountainArray
 * @Date: 2021/10/02/ 13:54
 * @Author 萧瑟
 * @Description 0941
 */
public class ValidMountainArray {

    /**
     * 单指针
     * 以及 双指针
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 1;
        while (i<arr.length && arr[i-1]<arr[i]) i++;
        if (i==1) return false;
        if (i==arr.length || arr[i-1]==arr[i]) return false;
        while (i<arr.length && arr[i-1]>arr[i]) i++;
        if (i!=arr.length && arr[i-1]<=arr[i] ) return false;
        return true;
    }

}
