package com.alibaba.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the empty string "". If there is such window,
 * you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * 
 * @author wang
 * @date 2019/07/21
 */
public class MinimumWindowSubstringSolution {

    public static void main(String[] args) {

        System.out.println(new MinimumWindowSubstringSolution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstringSolution().minWindow("a", "aa"));
        System.out.println(new MinimumWindowSubstringSolution().minWindow("bbaa", "abb"));
        
        System.out.println(new MinimumWindowSubstringSolution().minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstringSolution().minWindow2("a", "aa"));
        System.out.println(new MinimumWindowSubstringSolution().minWindow2("bbaa", "abb"));
    }

    public String minWindow2(String s, String t) {

        if (t == null || s == null || s.length() < t.length()) {
            return "";
        }

        int l = 0;
        int r = 0;
        int ansL = 0;
        int ansR = -1;
        int minLen = Integer.MAX_VALUE;
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map[c]++;
        }

        int count = t.length();
        while (r < s.length()) {
            char cr = s.charAt(r);
            map[cr]--;
            if (map[cr] >= 0) {
                count--;
            }
            while (count == 0) {
                int len = r - l + 1;
                if (len < minLen) {
                    ansL = l;
                    ansR = r;
                    minLen = len;
                }
                char cl = s.charAt(l);
                map[cl]++;
                if (map[cl] > 0) {
                    count++;
                }

                l++;
            }
            r++;
        }

        return s.substring(ansL, ansR + 1);
    }

    public String minWindow(String s, String t) {

        if (t == null || s == null || s.length() < t.length()) {
            return "";
        }

        int l = 0;
        int r = 0;
        String min = null;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer val = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), val + 1);
        }

        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                while (match(map)) {
                    String sub = s.substring(l, r + 1);
                    min = (min == null ? sub : (min.length() > sub.length() ? sub : min));
                    char cl = s.charAt(l);
                    if (map.containsKey(cl)) {
                        map.put(cl, map.get(cl) + 1);
                    }
                    l++;
                }
            }
            r++;
        }

        return (min == null) ? "" : min;
    }

    private boolean match(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

}
