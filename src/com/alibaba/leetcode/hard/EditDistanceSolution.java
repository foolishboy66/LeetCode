package com.alibaba.leetcode.hard;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3
 * 
 * Explanation: horse -> rorse (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * 
 * Example 2:
 * 
 * Input: word1 = "intention", word2 = "execution" Output: 5
 * 
 * Explanation: intention -> inention (remove 't') inention -> enention (replace 'i' with 'e') enention -> exention
 * (replace 'n' with 'x') exention -> exection (replace 'n' with 'c') exection -> execution (insert 'u')
 * 
 * 
 * @author wang
 * @date 2019/07/20
 */
public class EditDistanceSolution {

    public static void main(String[] args) {

        System.out.println(new EditDistanceSolution().minDistance("1", "2"));
        System.out.println(new EditDistanceSolution().minDistance("aa", "aa"));
        System.out.println(new EditDistanceSolution().minDistance("horse", "ros"));
        System.out.println(new EditDistanceSolution().minDistance("intention", "execution"));
    }

    /**
     * 动态规划：d[i][j]表示第一个单词前i和字母与第二个单词的前j个字母最小的编辑距离
     * 
     * 动态方程： 若word1.charAt[i] == word2.charAt[j]，dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1])
     * 若word1.charAt[i] != word2.charAt[j]，dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
     * 
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

    private int getMin(int... nums) {

        int min = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
        }
        return min;
    }

}
