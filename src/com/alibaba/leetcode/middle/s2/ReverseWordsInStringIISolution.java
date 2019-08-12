package com.alibaba.leetcode.middle.s2;

/**
 * 186.Reverse Words in a String II
 * 
 * 186. 翻转字符串里的单词 II
 * 
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * 
 * For example,
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * 
 * @author wang
 * @date 2019/08/12
 */
public class ReverseWordsInStringIISolution {

    public static void main(String[] args) {

        char[] chs = "the sky is blue".toCharArray();
        new ReverseWordsInStringIISolution().reverseWords(chs);
        System.out.println(new String(chs));
    }

    /**
     * 先将整个字符数组翻转，然后将每个单词在进行翻转即可
     * 
     * @param chs
     */
    public void reverseWords(char[] chs) {

        if (chs.length == 0) {
            return;
        }

        reverse(chs, 0, chs.length - 1);

        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ' && start < i - 1) {
                reverse(chs, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chs, start, chs.length - 1);
    }

    private void reverse(char[] chs, int start, int end) {

        while (start < end) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }
}
