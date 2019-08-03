package com.alibaba.leetcode.hard.s2;

/**
 * 132. Palindrome Partitioning II
 * 
 * 132. 分割回文串 II
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab"
 * 
 * Output: 1
 * 
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class PalindromePartitioningIISolution {

    public static void main(String[] args) {

        System.out.println(new PalindromePartitioningIISolution().minCut("aab"));
    }

    /**
     * 动态规划，dp[i][j]记录从j到i的字符串能否构成回文串，min[i]记录到i的下标构成的回文串的最小分割次数
     * 
     * 动态方程：当s[i] == s[j]时，dp[i][j] = dp[i-1][j+1]
     * 
     * min[i] = min(min[i], min[j-1]+1)
     * 
     * @param s
     * @return
     */
    public int minCut(String s) {

        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        int[] min = new int[len];

        for (int i = 0; i < len; i++) {
            min[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
                }
            }
        }

        return min[len - 1];
    }
}
