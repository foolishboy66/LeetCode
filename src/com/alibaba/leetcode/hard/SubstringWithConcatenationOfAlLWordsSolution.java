package com.alibaba.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9] Explanation: Substrings starting at index 0 and
 * 9 are "barfoor" and "foobar" respectively. The output order does not matter, returning [9,0] is fine too. Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] Output: []
 * 
 * 
 * @author wang
 * @date 2019/07/07
 */
public class SubstringWithConcatenationOfAlLWordsSolution {

    public static void main(String[] args) {

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("barfoothefoobarman",
            new String[] {"foo", "bar"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("wordgoodgoodgoodbestword",
            new String[] {"word", "good", "best", "word"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("foobarfoobar",
            new String[] {"foo", "bar"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("a", new String[] {}));
        System.out
            .println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("aaa", new String[] {"a", "a"}));
        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("abababab",
            new String[] {"a", "b", "a"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring("barfoothefoobarman",
            new String[] {"foo", "bar"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring("wordgoodgoodgoodbestword",
            new String[] {"word", "good", "best", "word"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring("foobarfoobar",
            new String[] {"foo", "bar"}));

        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring("a", new String[] {}));
        System.out
            .println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring("aaa", new String[] {"a", "a"}));
        System.out.println(new SubstringWithConcatenationOfAlLWordsSolution().findSubstring2("abababab",
            new String[] {"a", "b", "a"}));
    }

    /**
     * 数组data中每个元素的全排列
     * 
     * @param data
     * @param k
     * @param output
     */
    public void sq(String[] data, int k, List<String> output) {
        if (k == data.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]);
            }
            output.add(sb.toString());
        }

        for (int i = k; i < data.length; i++) {
            {
                String temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }

            sq(data, k + 1, output);
            {
                String temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }
    }

    /**
     * 解法二：
     * 
     * 1、由于每个单词长度一样，窗口向右扩展以单词为单位，当遇到不存在的单词，窗口清空，从下一个单词开始匹配
     * 
     * 2、当遇到重复次数过多的单词，窗口左侧收缩到第一次重复的位置的下一个单词，相当于窗口从左侧删除了重复单词
     * 
     * 3、当窗口长度等于单词总长度时，说明遇到了匹配的子串
     * 
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return ans;
        }
        int wordNum = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            Integer count = allWords.getOrDefault(word, 0);
            allWords.put(word, count + 1);
        }

        for (int j = 0; j < wordLen; j++) {
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            for (int i = j; i <= s.length() - wordLen * wordNum; i = i + wordLen) {
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        Integer count = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, count + 1);
                        if (allWords.get(word) < hasWords.get(word)) {
                            int removedNum = 0;
                            while (allWords.get(word) < hasWords.get(word)) {
                                String removeWord =
                                    s.substring(i + removedNum * wordLen, i + (removedNum + 1) * wordLen);
                                Integer val = hasWords.get(removeWord);
                                hasWords.put(removeWord, val - 1);
                                removedNum++;
                            }
                            i += wordLen * (removedNum - 1);
                            num = num - removedNum + 1;
                            break;
                        }
                    } else {
                        i += wordLen * num;
                        hasWords.clear();
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    ans.add(i);
                    String firstWord = s.substring(i, i + wordLen);
                    Integer val = hasWords.get(firstWord);
                    hasWords.put(firstWord, val - 1);
                    num--;
                }
            }
        }

        return ans;
    }

    /**
     * 解法一：先计算出works数组元素的全排列，然后计算每个组合在s中的位置
     * 
     * 复杂度太高，会超时
     * 
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {

        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<String> ll = new ArrayList<>();
        sq(words, 0, ll);

        Set<Integer> ans = new HashSet<>();
        for (String sub : ll) {
            for (int i = 0; i < s.length();) {
                String tmp = s.substring(i);
                int index = tmp.indexOf(sub);
                if (index == -1) {
                    break;
                }
                ans.add(index + i);
                i++;
            }
        }

        return new ArrayList<>(ans);
    }

    @SuppressWarnings("unused")
    private boolean isAllCharSame(String sub) {

        char c = sub.charAt(0);
        for (int i = 1; i < sub.length(); i++) {
            if (c != sub.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
