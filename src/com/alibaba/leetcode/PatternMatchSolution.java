package com.alibaba.leetcode;

public class PatternMatchSolution {

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * 
     * '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover
     * the entire input string (not partial).
     * 
     * Note:
     * 
     * s could be empty and contains only lowercase letters a-z. p could be empty and contains only lowercase letters
     * a-z, and characters like . or *. Example 1:
     * 
     * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the entire string "aa". Example 2:
     * 
     * Input: s = "aa" p = "a*" Output: true Explanation: '*' means zero or more of the precedeng element, 'a'.
     * Therefore, by repeating 'a' once, it becomes "aa". Example 3:
     * 
     * Input: s = "ab" p = ".*" Output: true Explanation: ".*" means "zero or more (*) of any character (.)". Example 4:
     * 
     * Input: s = "aab" p = "c*a*b" Output: true Explanation: c can be repeated 0 times, a can be repeated 1 time.
     * Therefore it matches "aab". Example 5:
     * 
     * Input: s = "mississippi" p = "mis*is*p*." Output: false
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("method1----------");
        System.out.println(new PatternMatchSolution().isMatch("aa", "a*"));
        System.out.println(new PatternMatchSolution().isMatch("ab", ".*"));
        System.out.println(new PatternMatchSolution().isMatch("aab", "c*a*b"));
        System.out.println(new PatternMatchSolution().isMatch("mississippi", "mis*is*p*"));
        System.out.println(new PatternMatchSolution().isMatch("a", "a*"));

        System.out.println("method2----------");
        System.out.println(new PatternMatchSolution().isMatch2("aa", "a*"));
        System.out.println(new PatternMatchSolution().isMatch2("ab", ".*"));
        System.out.println(new PatternMatchSolution().isMatch2("aab", "c*a*b"));
        System.out.println(new PatternMatchSolution().isMatch2("mississippi", "mis*is*p*"));
        System.out.println(new PatternMatchSolution().isMatch2("a", "a*"));

        System.out.println("method3----------");
        System.out.println(new PatternMatchSolution().isMatch3("aa", "a*"));
        System.out.println(new PatternMatchSolution().isMatch3("ab", ".*"));
        System.out.println(new PatternMatchSolution().isMatch3("aab", "c*a*b"));
        System.out.println(new PatternMatchSolution().isMatch3("mississippi", "mis*is*p*"));
        System.out.println(new PatternMatchSolution().isMatch3("a", "a*"));
    }

    /**
     * 解法一：直接使用jdk自带的matches方法
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        return s.matches(p);
    }

    /**
     * 解法二：递归回溯法
     * 
     * 1、如果匹配模式没有*，那么一一匹配即可
     * 
     * 2、如果有*，必然出现在第二个位置（匹配过的丢弃掉），这时可以把前边一部分全部丢掉或者从p[0]开始再次匹配
     * 
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstMatch = s.length() > 0 && p.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch2(s, p.substring(2)) || (firstMatch && isMatch2(s.substring(1), p));
        } else {
            return firstMatch && isMatch2(s.substring(1), p.substring(1));
        }
    }

    /**
     * 解法三：动态规划，使用二维数组保留之前遍历过的结果
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
