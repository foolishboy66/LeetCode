package com.alibaba.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 * @author wang
 * @date 2019/07/01
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {

        System.out
            .println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {"fl", "fl", "fl"}));
        System.out.println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {"dog", "pig", "fl"}));
        System.out.println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {"dog", "dpig", "dfl"}));
        System.out.println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {}));
        System.out.println(new LongestCommonPrefixSolution().longestCommonPrefix(new String[] {"abab", "aba", "abc"}));
    }

    /**
     * 先找出最短的字符串，从全长开始匹配，然后采用折半的思想匹配最长前缀
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String min = strs[0];
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (min.length() > strs[i].length()) {
                min = strs[i];
                index = i;
            }
        }

        int i = min.length();
        int last = 0;
        String tmp = "";
        String ans = "";
        while (last != i) {
            tmp = min.substring(0, i);
            boolean allMatch = true;
            for (int j = 0; j < strs.length; j++) {
                if (j != index && !strs[j].startsWith(tmp)) {
                    allMatch = false;
                }
            }
            if (allMatch && last == 0) {
                return tmp;
            }
            if (i - last == 1 || i - last == 0) {
                return allMatch ? tmp : ans;
            }
            if (allMatch) {
                int t = i;
                i = (i + last) / 2;
                last = t;
                ans = tmp;
            } else {
                last = i;
                i = i / 2;
            }
        }
        return ans;
    }
}
