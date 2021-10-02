package com.nuaa.xiaose.array.medium;

import java.util.Arrays;

/**
 * @author: xiaose
 * @time: 2021/10/1 22:53
 * @description: 0204
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {


    /**
     * 埃氏筛
     * 我们考虑这样一个事实：如果 xx 是质数，那么大于 xx 的 xx 的倍数 2x,3x,\ldots2x,3x,… 一定不是质数，因此我们可以从这里入手。
     * 当然这里还可以继续优化，对于一个质数 xx，如果按上文说的我们从 2x2x 开始标记其实是冗余的，应该直接从 x*x 开始标记，因为 2x,3x,\ldots2x,3x,… 这些数一定在 xx 之前就被其他数的倍数标记过了，例如 22 的所有倍数，33 的所有倍数等。
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j+=i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        countPrimes(10);
    }
}
