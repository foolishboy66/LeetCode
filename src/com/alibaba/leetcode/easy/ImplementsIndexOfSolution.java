package com.alibaba.leetcode.easy;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 * 
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
 * and Java's indexOf().
 * 
 * 
 * @author wang
 * @date 2019/07/05
 */
public class ImplementsIndexOfSolution {

    public static void main(String[] args) {

        System.out.println(new ImplementsIndexOfSolution().strStr("hello", "ll"));
        System.out.println(new ImplementsIndexOfSolution().strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null || needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                index = i;
                break;
            }
        }

        return index;
    }
}
