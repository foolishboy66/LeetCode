package com.alibaba.leetcode.easy.s2;

/**
 * 198. House Robber
 * 
 * 198. 打家劫舍
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1]
 * 
 * Output: 4
 * 
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).   Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * Input: [2,7,9,3,1]
 * 
 * Output: 12
 * 
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).   Total amount you can rob
 * = 2 + 9 + 1 = 12.
 * 
 * @author wang
 * @date 2019/08/14
 */
public class HouseRobberSolution {

    public static void main(String[] args) {

        System.out.println(new HouseRobberSolution().rob(new int[] {1, 2, 3, 1}));
        System.out.println(new HouseRobberSolution().rob(new int[] {2, 7, 9, 3, 1}));
    }

    /**
     * 动态规划：dp[i]表示第i天能打劫到的最大金额
     * 
     * 动态方程如下为：dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }
}
