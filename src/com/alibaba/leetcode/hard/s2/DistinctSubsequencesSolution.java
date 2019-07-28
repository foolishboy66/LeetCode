package com.alibaba.leetcode.hard.s2;

/**
 * 115. Distinct Subsequences
 * 
 * 115. 不同的子序列
 * 
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * Example 1:
 * 
 * Input: S = "rabbbit", T = "rabbit" Output: 3
 * 
 * Explanation:
 * 
 * As shown below, there are 3 ways you can generate "rabbit" from S. (The caret symbol ^ means the chosen letters)
 * 
 * rabbbit ^^^^ ^^ rabbbit ^^ ^^^^ rabbbit ^^^ ^^^
 * 
 * Example 2:
 * 
 * Input: S = "babgbag", T = "bag" Output: 5 Explanation:
 * 
 * As shown below, there are 5 ways you can generate "bag" from S. (The caret symbol ^ means the chosen letters)
 * 
 * babgbag ^^ ^ babgbag ^^ ^ babgbag ^ ^^ babgbag ^ ^^ babgbag ^^^
 * 
 * 
 * @author wang
 * @date 2019/07/28
 */
public class DistinctSubsequencesSolution {

    public static void main(String[] args) {

        System.out.println(new DistinctSubsequencesSolution().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequencesSolution().numDistinct("babgbag", "bag"));
    }

    /**
     * 动态规划：dp[i][j]表示s的前i个字符序列与t的前j个字符匹配的个数
     * 
     * 当s[i-1] == t[j-1]时有dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     * 
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        if (s.length() < t.length()) {
            return 0;
        }
        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    // i>0 && j>0
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
