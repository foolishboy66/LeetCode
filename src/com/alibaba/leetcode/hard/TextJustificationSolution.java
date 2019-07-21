package com.alibaba.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and
 * is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * Note:
 * 
 * A word is defined as a character sequence consisting of non-space characters only. Each word's length is guaranteed
 * to be greater than 0 and not exceed maxWidth. The input array words contains at least one word. Example 1:
 * 
 * Input:
 * 
 * words = ["This", "is", "an", "example", "of", "text", "justification."] maxWidth = 16
 * 
 * Output: [    "This    is    an",    "example  of text",    "justification.  " ] Example 2:
 * 
 * Input:
 * 
 * words = ["What","must","be","acknowledgment","shall","be"] maxWidth = 16
 * 
 * Output: [   "What   must   be",   "acknowledgment  ",   "shall be        " ] Explanation: Note that the last line is
 * "shall be " instead of "shall be",   because the last line must be left-justified instead of fully-justified. Note
 * that the second line is also left-justified becase it contains only one word. Example 3:
 * 
 * Input:
 * 
 * words = ["Science","is","what","we","understand","well","enough","to","explain",  
 * "to","a","computer.","Art","is","everything","else","we","do"] maxWidth = 20
 * 
 * Output: [   "Science  is  what we", "understand      well",   "enough to explain to",   "a  computer.  Art is",  
 * "everything  else  we",   "do                  " ]
 * 
 * 
 * @author wang
 * @date 2019/07/19
 */
public class TextJustificationSolution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString("          a          b ".replaceAll(" +", " ").split(" ")));

        System.out.println(new TextJustificationSolution()
            .fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));

        System.out.println(new TextJustificationSolution()
            .fullJustify(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"}, 16));

        System.out.println(new TextJustificationSolution()
            .fullJustify(new String[] {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

        System.out.println(new TextJustificationSolution().fullJustify(new String[] {"Science", "is", "what"}, 60));

    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }

        for (int i = 0; i < words.length; i++) {
            int left = maxWidth;
            List<String> tmp = new ArrayList<>();
            for (int j = i; j < words.length; j++) {
                if (left < words[j].length()) {
                    i--;
                    break;
                }
                tmp.add(words[j]);
                left = left - words[j].length() - 1;
                i++;
            }
            res.add(balanceWords(tmp, maxWidth));
        }

        String ss = res.get(res.size() - 1);
        res.remove(res.size() - 1);
        res.add(handleLastLine(ss, maxWidth));

        return res;
    }

    private String handleLastLine(String str, int maxWidth) {

        StringBuilder sb = new StringBuilder();
        str = str.replaceAll(" +", " ");
        String[] ss = str.trim().split(" ");
        sb.append(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            if (!ss[i].isEmpty() && !ss[i].trim().isEmpty()) {
                sb.append(" ");
                sb.append(ss[i].trim());
            }
        }
        sb.append(getNWhiteSpace(maxWidth - sb.length()));

        return sb.toString();
    }

    private String getNWhiteSpace(int num) {

        if (num == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String balanceWords(List<String> strs, int maxWidth) {

        if (strs.size() == 1) {
            return strs.get(0) + getNWhiteSpace(maxWidth - strs.get(0).length());
        }

        int total = 0;
        for (String str : strs) {
            total += str.length();
        }
        int num = maxWidth - total;

        int avg = num / (strs.size() - 1);
        int abundunt = num % (strs.size() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(strs.get(0));

        for (int i = 1; i < strs.size(); i++) {
            if (abundunt > 0) {
                sb.append(getNWhiteSpace(avg + 1));
                abundunt--;
            } else {
                sb.append(getNWhiteSpace(avg));
            }

            sb.append(strs.get(i));
        }

        return sb.toString();
    }
}
