package com.nuaa.xiaose.array.easy;

/**
 * @Classname BestTimetoBuyandSellStock1AND2
 * @Date: 2021/10/01/ 19:06
 * @Author 萧瑟
 * @Description 0121
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit1(prices);
        System.out.println(profit1);
    }

    /**
     * 买卖股票的最佳时机 1
     * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 思路:
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
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
            dp[i%2][1] = Math.max(dp[(i - 1)%2][1], - prices[i]);
        }
        return dp[(prices.length - 1) & 1][0];
    }
}
