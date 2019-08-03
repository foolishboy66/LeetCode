package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 
 * 131. 分割回文串
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab"
 * 
 * Output:
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class PalindromePartitioningSolution {

    public static void main(String[] args) {

        System.out.println(new PalindromePartitioningSolution().partition("aab"));
    }

    /**
     * 回溯法
     * 
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backTrack(s, 0, ans, new ArrayList<>());

        return ans;
    }

    private void backTrack(String s, int start, List<List<String>> ans, List<String> temp) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                temp.add(str);
                backTrack(s, i + 1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String str) {

        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
