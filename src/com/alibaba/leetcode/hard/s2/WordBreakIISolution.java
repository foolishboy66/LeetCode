package com.alibaba.leetcode.hard.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 140. Word Break II
 * 
 * 140. 单词拆分 II
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the segmentation. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * s = "catsanddog"
 * 
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 
 * Output:
 * 
 * [   "cats and dog",   "cat sand dog" ]
 * 
 * Example 2:
 * 
 * Input: s = "pineapplepenapple"
 * 
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 
 * Output: [   "pine apple pen apple",   "pineapple pen apple",   "pine applepen apple" ]
 * 
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * 
 * Input: s = "catsandog"
 * 
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 
 * Output: []
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class WordBreakIISolution {

    public static void main(String[] args) {

        System.out.println(
            new WordBreakIISolution().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

        System.out.println(
            new WordBreakIISolution().wordBreak2("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

        System.out.println(
            new WordBreakIISolution().wordBreak3("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    /**
     * 以单词表作为主体去回溯
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak3(String s, List<String> wordDict) {

        Map<String, List<String>> cache = new HashMap<>();

        return backTrack(cache, s, wordDict);
    }

    private List<String> backTrack(Map<String, List<String>> cache, String s, List<String> wordDict) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> ans = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    ans.add(s);
                } else {
                    List<String> temp = backTrack(cache, s.substring(word.length()), wordDict);
                    for (String str : temp) {
                        ans.add(word + " " + str);
                    }
                }
            }
        }

        cache.put(s, ans);
        return ans;
    }

    /**
     * 动态规划：超时无法ac
     * 
     * @param s
     * @param wordDict
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<String> wordBreak2(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        List<String>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>(Arrays.asList(""));
        for (int i = 1; i <= s.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dict.contains(str) && dp[j] != null) {
                    for (String ss : dp[j]) {
                        if (ss == "") {
                            temp.add(str);
                        } else {
                            temp.add(ss + " " + str);
                        }
                    }
                }
            }
            dp[i] = temp;
        }

        return dp[s.length()];
    }

    /**
     * 回溯法：超时无法ac
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();

        backTrack(s, 0, wordDict, ans, new ArrayList<>());
        return ans;
    }

    private void backTrack(String s, int i, List<String> wordDict, List<String> ans, List<String> temp) {

        if (i == s.length()) {
            ans.add(String.join(" ", temp));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String ss = s.substring(i, j + 1);
            if (wordDict.contains(ss)) {
                temp.add(ss);
                backTrack(s, j + 1, wordDict, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
