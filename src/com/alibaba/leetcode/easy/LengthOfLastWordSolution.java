package com.alibaba.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
 * word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example:
 * 
 * Input: "Hello World" Output: 5
 * 
 * 
 * @author wang
 * @date 2019/07/17
 */
public class LengthOfLastWordSolution {

    public static void main(String[] args) {

        System.out.println(new LengthOfLastWordSolution().lengthOfLastWord("Hello World"));
    }

    /**
     * 先去空格，然后从后往前遍历
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {

        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        String ss = s.trim();
        int len = 0;
        for (int i = ss.length() - 1; i >= 0; i--) {
            if (ss.charAt(i) != ' ') {
                len++;
            } else {
                break;
            }
        }

        return len;
    }
}
