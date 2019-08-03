package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 * 
 * 127. 单词接龙
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word. Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * 
 * All words have the same length. All words contain only lowercase alphabetic characters. You may assume no duplicates
 * in the word list. You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * beginWord = "hit",
 * 
 * endWord = "cog",
 * 
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Example 2:
 * 
 * Input:
 * 
 * beginWord = "hit"
 * 
 * endWord = "cog"
 * 
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * 
 * @author wang
 * @date 2019/07/31
 */
public class WordLadderSolution {

    public static void main(String[] args) {

        System.out.println(new WordLadderSolution().ladderLength("hit", "cog",
            new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

        System.out.println(new WordLadderSolution().ladderLength("hit", "cog",
            new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }

    /**
     * 相差一个字母的单词组成这个单词的邻接表，使用bfs遍历邻接表即可
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int len = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return len + 1;
                }

                Iterator<String> it = wordList.iterator();
                while (it.hasNext()) {
                    String curr = it.next();
                    if (adjcent(temp, curr)) {
                        queue.add(curr);
                        it.remove();
                    }
                }
            }
            len++;
        }

        return 0;
    }

    private boolean adjcent(String temp, String curr) {

        int diff = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != curr.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
