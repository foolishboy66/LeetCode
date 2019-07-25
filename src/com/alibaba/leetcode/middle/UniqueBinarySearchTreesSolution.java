package com.alibaba.leetcode.middle;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * Example:
 * 
 * Input: 3 Output: 5
 * 
 * Explanation:
 * 
 * Given n = 3, there are a total of 5 unique BST's
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/25
 */
public class UniqueBinarySearchTreesSolution {

    public static void main(String[] args) {

        System.out.println(new UniqueBinarySearchTreesSolution().numTrees(3));
        System.out.println(new UniqueBinarySearchTreesSolution().numTrees2(3));
    }

    /**
     * 动态规划：若用f[i]表示以i作为根节点有多少种二叉搜索树，dp[i]表示长度为i的序列二叉树的数目， 则会有f[i] = dp[i-1] * dp[n-i]，
     * 
     * 而最终的dp[n] = f[i] (其中i从0到n)的求和
     * 
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    /**
     * 公式法：卡特兰数dp[n] = dp[0]*dp[n] + dp[1]*dp[n-1] + ... + dp[n-1]*dp[1] + dp[n]*dp[0]
     * 
     * dp[n+1] = 2*dp[n]*(2*n+1)/(n+2)
     * 
     * @param n
     * @return
     */
    public int numTrees2(int n) {

        long dp = 1;

        for (int i = 0; i < n; i++) {
            dp = dp * 2 * (2 * i + 1) / (i + 2);
        }

        return (int)dp;
    }

}
