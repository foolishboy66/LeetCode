package com.alibaba.leetcode.easy.s2;

/**
 * 125. Valid Palindrome
 * 
 * 125. 验证回文串
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: "race a car"
 * 
 * Output: false
 * 
 * 
 * @author wang
 * @date 2019/07/30
 */
public class ValidPalindromeSolution {

    public static void main(String[] args) {

        System.out.println(new ValidPalindromeSolution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindromeSolution().isPalindrome("race a car"));
        System.out.println(new ValidPalindromeSolution().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.trim() == "") {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!isLetter(s.charAt(i)) && i < j) {
                i++;
            }
            while (!isLetter(s.charAt(j)) && i < j) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j) && Math.abs(s.charAt(i) - s.charAt(j)) != 32
                || Math.abs(s.charAt(i) - s.charAt(j)) == 32 && (isNumber(s.charAt(i)) || isNumber(s.charAt(j)))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isLetter(char c) {

        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private boolean isNumber(char c) {

        return c >= '0' && c <= '9';
    }

}
