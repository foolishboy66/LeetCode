package com.alibaba.leetcode.hard;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *  great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

 * 
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 * rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

 * 
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 *  rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
 * 
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * Example 1:
 * 
 * Input: s1 = "great", s2 = "rgeat"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s1 = "abcde", s2 = "caebd" Output: false
 * 
 * 
 * @author wang
 * @date 2019/07/23
 */
public class ScrambleStringSolution {

    public static void main(String[] args) {

        System.out.println(new ScrambleStringSolution().isScramble("great", "rgeat"));
        System.out.println(new ScrambleStringSolution().isScramble("great", "caebd"));
        System.out.println(new ScrambleStringSolution().isScramble("abb", "bba"));
    }

    /**
     * 递归分治法：判断两个字符串是否相同，然后递归判断子串是否相同。判断子串时需要判断交换子串部分的位置时能否匹配
     * 
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        char[] cs = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            cs[s1.charAt(i) - 'a']++;
            cs[s2.charAt(i) - 'a']--;
        }

        for (char c : cs) {
            if (c != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                || isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }

        return false;
    }
}
