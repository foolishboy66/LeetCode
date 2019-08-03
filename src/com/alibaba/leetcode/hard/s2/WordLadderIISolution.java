package com.alibaba.leetcode.hard.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 126. Word Ladder II
 * 
 * 126. 单词接龙 II
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word. Note:
 * 
 * Return an empty list if there is no such transformation sequence. All words have the same length. All words contain
 * only lowercase alphabetic characters. You may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same.
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
 * Output:
 * 
 * [ ["hit","hot","dot","dog","cog"],   ["hit","hot","lot","log","cog"] ]
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
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * 
 * @author wang
 * @date 2019/08/01
 */
public class WordLadderIISolution {

    public static void main(String[] args) {

        System.out.println(new WordLadderIISolution().findLadders("hit", "cog",
            new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

        System.out.println(
            new WordLadderIISolution().findLadders("hot", "dog", new ArrayList<>(Arrays.asList("hot", "dog"))));
    }

    /**
     * bfs+dfs
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();

        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return res;
        }
        int begin = wordList.indexOf(beginWord);
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.indexOf(beginWord);
        }

        // 获取邻接表
        Map<Integer, List<Integer>> next = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            next.put(i, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (adjcent(wordList.get(i), wordList.get(j))) {
                    next.get(i).add(j);
                    next.get(j).add(i);
                }
            }
        }

        // bfs获取到每个单词的距离
        Queue<Integer> q = new LinkedList<>();
        q.add(begin);
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(begin, 0);
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            for (Integer curr : next.get(temp)) {
                if (!distance.containsKey(curr)) {
                    distance.put(curr, distance.get(temp) + 1);
                    q.add(curr);
                }
            }
        }

        // dfs获取路径
        List<Integer> temp = new ArrayList<>();
        temp.add(begin);
        dfs(res, begin, end, next, distance, temp, wordList);

        return res;
    }

    private void dfs(List<List<String>> res, int curr, int end, Map<Integer, List<Integer>> next,
        Map<Integer, Integer> distance, List<Integer> temp, List<String> wordList) {

        if (temp.size() > 0 && temp.get(temp.size() - 1) == end) {
            res.add(getPath(temp, wordList));
            return;
        }

        for (Integer nextIndex : next.get(curr)) {

            if (distance.get(nextIndex) == distance.get(curr) + 1) {
                temp.add(nextIndex);
                dfs(res, nextIndex, end, next, distance, temp, wordList);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private List<String> getPath(List<Integer> temp, List<String> wordList) {

        List<String> ans = new ArrayList<>();
        for (Integer i : temp) {
            ans.add(wordList.get(i));
        }

        return ans;
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
