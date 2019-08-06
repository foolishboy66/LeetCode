package com.alibaba.leetcode.middle.s2;

import java.util.LinkedList;

/**
 * 151. Reverse Words in a String
 * 
 * 151. 翻转字符串里的单词
 * 
 * Given an input string, reverse the string word by word.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: "the sky is blue"
 * 
 * Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: "  hello world!  "
 * 
 * Output: "world! hello"
 * 
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * 
 * Input: "a good   example"
 * 
 * Output: "example good a"
 * 
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.  
 * 
 * Note:
 * 
 * A word is defined as a sequence of non-space characters. Input string may contain leading or trailing spaces.
 * However, your reversed string should not contain leading or trailing spaces. You need to reduce multiple spaces
 * between two words to a single space in the reversed string.  
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 * 
 * 
 * @author wang
 * @date 2019/08/06
 */
public class ReverseWordsInStringSolution {

    public static void main(String[] args) {

        System.out.println(new ReverseWordsInStringSolution().reverseWords(" a good    example"));

        System.out.println(new ReverseWordsInStringSolution().reverseWords2(" a good    example"));
    }

    /**
     * 解法二：逆序遍历字符串，使用StringBuild保存结果
     * 
     * @param s
     * @return
     */
    public String reverseWords2(String s) {

        if (s == null || s == "") {
            return s;
        }

        int len = s.length() - 1;
        char[] chs = s.toCharArray();
        while (len >= 0 && chs[len] == ' ') {
            len--;
        }

        int l = len + 1;
        int r = len + 1;
        StringBuilder sb = new StringBuilder();
        while (len >= 0) {
            if (chs[len] == ' ') {
                if (l < r) {
                    sb.append(chs, l, r - l).append(" ");
                }
                r = len;
            }
            l = len;
            len--;
        }
        if (l < r) {
            sb.append(chs, l, r - l).append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    /**
     * 解法一：使用list保存单词，然后利用" "串起来
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        if (s == null || s.trim() == "") {
            return null;
        }
        char[] chs = new char[s.length()];
        int len = 0;
        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (len > 0) {
                    words.addFirst(new String(chs, 0, len));
                    len = 0;
                    chs = new char[s.length() - i];
                }
            } else {
                chs[len] = c;
                len++;
            }
        }
        if (len > 0) {
            words.addFirst(new String(chs, 0, len));
        }
        return String.join(" ", words);
    }

}
