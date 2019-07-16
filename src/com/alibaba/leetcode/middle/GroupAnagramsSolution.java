package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * 
 * @author wang
 * @date 2019/07/15
 */
public class GroupAnagramsSolution {

    public static void main(String[] args) {

        System.out.println(
            new GroupAnagramsSolution().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(
            new GroupAnagramsSolution().groupAnagrams2(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 将字符串转为字符数组后排序，字符串分组
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                map.put(s, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 解法一：暴力分组法
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charMap = getCharMap(str);
            if (map.containsKey(charMap)) {
                List<String> list = map.get(charMap);
                list.add(str);
            } else {
                map.put(charMap, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    private Map<Character, Integer> getCharMap(String str) {

        Map<Character, Integer> res = new TreeMap<>();
        for (char c : str.toCharArray()) {
            Integer val = res.getOrDefault(c, 0);
            res.put(c, val + 1);
        }
        return res;
    }
}
