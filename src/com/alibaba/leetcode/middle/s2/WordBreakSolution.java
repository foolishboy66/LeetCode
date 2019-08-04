package com.alibaba.leetcode.middle.s2;

import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 * 
 * 139. 单词拆分
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the segmentation. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * 
 * Output: true
 * 
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * 
 * Output: true
 * 
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".   Note that you are allowed
 * to reuse a dictionary word.
 * 
 * Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 
 * Output: false
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class WordBreakSolution {

    public static void main(String[] args) {

        System.out.println(new WordBreakSolution().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreakSolution().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(
            new WordBreakSolution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

        System.out.println(new WordBreakSolution().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        
        System.out.println(new WordBreakSolution().wordBreak2("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    /**
     * 解法二：动态规划，dp[i]表示前i个字符能否被拆分为单词
     * 
     * 动态方程为：dp[i] = dp[j] && wordDict.contains(s.subStr(i,j)
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * 解法一：回溯法，超时无法ac
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        return backTrack(s, 0, wordDict);
    }

    private boolean backTrack(String s, int i, List<String> wordDict) {

        if (i == s.length()) {
            return true;
        }

        for (int j = i; j < s.length(); j++) {
            if (wordDict.contains(s.substring(i, j + 1)) && backTrack(s, j + 1, wordDict)) {
                return true;
            }
        }

        return false;
    }
}
