package com.alibaba.leetcode.hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 
 * Output: false
 * 
 * 
 * @author wang
 * @date 2019/07/25
 */
public class InterleavingStringSolution {

    public static void main(String[] args) {

        System.out.println(new InterleavingStringSolution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new InterleavingStringSolution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        System.out.println(new InterleavingStringSolution().isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new InterleavingStringSolution().isInterleave2("aabcc", "dbbca", "aadbbbaccc"));
    }

    /**
     * 解法二：动态规划
     * 
     * dp[i][j]存储s1的前i个字符与s2的前j个字符能否组成s3的前(i+j-1)个字符
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    /**
     * 解法一：回溯法，超时无法ac
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        return isInterleave(s1, 0, s2, 0, "", s3);
    }

    private boolean isInterleave(String s1, int i, String s2, int j, String tmp, String s3) {

        if (i == s1.length() && j == s2.length() && tmp.equals(s3)) {
            return true;
        }

        if (i < s1.length()) {
            if (isInterleave(s1, i + 1, s2, j, tmp + s1.charAt(i), s3)) {
                return true;
            }
        }
        if (j < s2.length()) {
            if (isInterleave(s1, i, s2, j + 1, tmp + s2.charAt(j), s3)) {
                return true;
            }
        }

        return false;
    }

}
