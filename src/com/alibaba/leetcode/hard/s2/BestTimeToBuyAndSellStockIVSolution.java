package com.alibaba.leetcode.hard.s2;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * 
 * 188. 买卖股票的最佳时机 IV
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy
 * again).
 * 
 * Example 1:
 * 
 * Input: [2,4,1], k = 2
 * 
 * Output: 2
 * 
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * 
 * Example 2:
 * 
 * Input: [3,2,6,5,0,3], k = 2
 * 
 * Output: 7
 * 
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.   Then buy on day 5 (price =
 * 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * 
 * @author wang
 * @date 2019/08/12
 */
public class BestTimeToBuyAndSellStockIVSolution {

    public static void main(String[] args) {

        System.out.println(new BestTimeToBuyAndSellStockIVSolution().maxProfit(2, new int[] {2, 4, 1}));
        System.out.println(new BestTimeToBuyAndSellStockIVSolution().maxProfit(2, new int[] {3, 2, 6, 5, 0, 3}));
    }

    /**
     * 动态规划：dp[i][j][k]表示第i天的第j次交易股票状态为k（k取值为0,1 {1:持有股票，0:没有持有股票}）时的最大收益
     * 
     * 则动态方程如下：
     * 
     * dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j][1] + prices[i])
     * 
     * dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i])
     * 
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        // 这里不加这个判断会导致内存超出限制
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }

        return dp[prices.length - 1][k][0];
    }

    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff;
            if ((diff = prices[i] - prices[i - 1]) > 0) {
                max += diff;
            }
        }

        return max;
    }
}
