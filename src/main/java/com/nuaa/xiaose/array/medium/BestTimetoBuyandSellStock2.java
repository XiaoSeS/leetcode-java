package com.nuaa.xiaose.array.medium;

/**
 * @Classname BestTimetoBuyandSellStock2
 * @Date: 2021/10/01/ 19:26
 * @Author 萧瑟
 * @Description  0122
 */
public class BestTimetoBuyandSellStock2 {

    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[2][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i%2][0] = Math.max(dp[(i - 1)%2][0], dp[(i - 1)%2][1] + prices[i]);
            dp[i%2][1] = Math.max(dp[(i - 1)%2][1], dp[(i - 1)%2][0]- prices[i]);
        }
        return dp[(prices.length - 1) & 1][0];
    }

}
