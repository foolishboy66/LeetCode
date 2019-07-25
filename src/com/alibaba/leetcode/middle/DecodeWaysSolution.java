package com.alibaba.leetcode.middle;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2
 * 
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * 
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * 
 * @author wang
 * @date 2019/07/24
 */
public class DecodeWaysSolution {

    public static void main(String[] args) {

        System.out.println(new DecodeWaysSolution().numDecodings("00"));
        System.out.println(new DecodeWaysSolution().numDecodings("0"));
        System.out.println(new DecodeWaysSolution().numDecodings("10"));
        System.out.println(new DecodeWaysSolution().numDecodings("12"));
        System.out.println(new DecodeWaysSolution().numDecodings("226"));
        System.out.println(new DecodeWaysSolution().numDecodings("012"));
        System.out.println(new DecodeWaysSolution().numDecodings("100"));
        System.out.println(new DecodeWaysSolution().numDecodings("110"));
        System.out.println(new DecodeWaysSolution().numDecodings("230"));
        System.out.println(new DecodeWaysSolution().numDecodings("1010"));
        System.out.println(new DecodeWaysSolution().numDecodings("121"));
        System.out.println(new DecodeWaysSolution().numDecodings("1212"));
    }

    /**
     * 动态规划：dp[i] = dp[i-1] + dp[i-2]
     * 
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
