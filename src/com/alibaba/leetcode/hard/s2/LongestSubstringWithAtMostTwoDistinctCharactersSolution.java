package com.alibaba.leetcode.hard.s2;

/**
 * 159.Longest Substring with At Most Two Distinct Characters
 * 
 * 159.至多包含两个不同字符的最长子串
 * 
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 * 
 * 示例 1:
 * 
 * 输入: "eceba"
 * 
 * 输出: 3
 * 
 * 解释: t 是 "ece"，长度为3。
 * 
 * 示例 2:
 * 
 * 输入: "ccaabbb"
 * 
 * 输出: 5
 * 
 * 解释: t 是 "aabbb"，长度为5
 * 
 * 
 * @author wang
 * @date 2019/08/07
 */
public class LongestSubstringWithAtMostTwoDistinctCharactersSolution {

    public static void main(String[] args) {

        System.out
            .println(new LongestSubstringWithAtMostTwoDistinctCharactersSolution().lengthOfLongestSubstring("eceba"));
        System.out
            .println(new LongestSubstringWithAtMostTwoDistinctCharactersSolution().lengthOfLongestSubstring("ccaabbb"));
    }

    /**
     * 双指针：start指向第一种字母的开始位置，newStart指向第二种字母的开始位置，
     * 
     * 当出现第三种字母时，调整start=newStart，newStart指向新的第三种字母
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len < 3) {
            return len;
        }

        int ans = 1;
        int start = 0;
        int newStart = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (newStart > 0 && s.charAt(i) != s.charAt(newStart - 1)) {
                    start = newStart;
                }
                newStart = i;
            }
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}
