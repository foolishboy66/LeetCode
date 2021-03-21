package com.alibaba.leetcode.easy.s2;

/**
 * 557. Reverse Words in a String III
 * 
 * 557. 反转字符串中的单词 III
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * 
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 * 
 * @author wang
 * @date 2019/08/17
 */
public class ReverseWordsInStringIIISolution {

    public static void main(String[] args) {

        System.out.println(new ReverseWordsInStringIIISolution().reverseWords("Let's take LeetCode contest"));
        System.out.println(new ReverseWordsInStringIIISolution().reverseWords(""));
    }

    public String reverseWords(String s) {

        if (s == null || s.trim().equals("")) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        String sb = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb = c + sb;
            } else {
                ans.append(sb).append(" ");
                sb = "";
            }
        }
        if (sb.length() > 0) {
            ans.append(sb).append(" ");
        }

        return ans.substring(0, ans.length() - 1).toString();
    }
}
