package com.alibaba.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 * 
 * @author wang
 * @date 2019/06/27
 */
public class LengthOfLongestSubstringSolution {

    /**
     * 方法一：使用map记录走过的字符，map的大小就是无重复的子串长度；当遇到重复的字符时，调整到重复的字符开始重新遍历
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        Character c;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(c = s.charAt(i))) {
                maxLength = Math.max(maxLength, map.size());
                i = map.get(c) + 1;
                map.clear();
            }
            map.put(s.charAt(i), i);
        }
        maxLength = Math.max(maxLength, map.size());

        return maxLength;
    }

    /**
     * 方法二：用map记录遍历过的字符，指针不后退，遇到重复字符时调整字符的stratIndex
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        Character c;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(c = s.charAt(i))) {
                index = Math.max(index, map.get(c) + 1);
            }
            maxLength = Math.max(maxLength, i - index + 1);
            map.put(c, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring("au"));
        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring("abba"));

        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring2("au"));
        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring2("dvdf"));
        System.out.println(new LengthOfLongestSubstringSolution().lengthOfLongestSubstring2("abba"));
    }

}
