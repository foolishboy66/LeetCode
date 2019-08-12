package com.alibaba.leetcode.hard.s2;

/**
 * 123. Best Time to Buy and Sell Stock III
 * 
 * 123. 买卖股票的最佳时机 III
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy
 * again).
 * 
 * Example 1:
 * 
 * Input: [3,3,5,0,0,3,1,4]
 * 
 * Output: 6
 * 
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.   Then buy on day 7 (price =
 * 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5]
 * 
 * Output: 4
 * 
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.   Note that you cannot buy on
 * day 1, buy on day 2 and sell them later, as you are   engaging multiple transactions at the same time. You must sell
 * before buying again.
 * 
 * Example 3:
 * 
 * Input: [7,6,4,3,1]
 * 
 * Output: 0
 * 
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * @author wang
 * @date 2019/07/30
 */
public class BestTimeToBuyAndSellStockIIISolution {

    public static void main(String[] args) {

        System.out.println(new BestTimeToBuyAndSellStockIIISolution().maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new BestTimeToBuyAndSellStockIIISolution().maxProfit(new int[] {1, 2, 3, 4, 5}));
        System.out.println(new BestTimeToBuyAndSellStockIIISolution().maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    /**
     * 动态规划：dp[i][j][k]表示第i天，已经买过j次，当前是否持有股票（k=0:没有，k=1：持有）的最大收益，
     * 
     * k：0->1表示买入，k+1，最大收益减prices[i]；1->0表示售出，最大收益加prices[i]
     * 
     * 则动态方程为
     * 
     * dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j][1] + prices[i])
     * 
     * dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j+1][0] - prices[i])
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < 3; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }

            }
        }

        return dp[prices.length - 1][2][0];
    }
}
