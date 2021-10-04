package com.nuaa.xiaose.string.easy;

/**
 * @Classname ImplementstrStr
 * @Date: 2021/10/02/ 14:51
 * @Author 萧瑟
 * @Description 0028
 * <p>
 * 实现strStr()函数。
 * <p>
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        strStrS2("safasdfasd","ababaf");
    }


    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP 解法 有点难理解  next 数组 --> 可以看看b站上面的时评
     * 还没有写完  只完成了next数组的初始化 部分
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrS2(String haystack, String needle) {

        int[] next = new int[needle.length() + 1];
        next[1] = 0;
        int i = 1, j = 0;
        while (i < needle.length()) {
            if (j == 0 || needle.charAt(i-1) == needle.charAt(j-1)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return 0;
    }
}
