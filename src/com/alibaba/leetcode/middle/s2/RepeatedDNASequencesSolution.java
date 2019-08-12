package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 187. 重复的DNA序列
 * 
 * 187. Repeated DNA Sequences
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
 * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * @author wang
 * @date 2019/08/12
 */
public class RepeatedDNASequencesSolution {

    public static void main(String[] args) {

        System.out
            .println(new RepeatedDNASequencesSolution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        System.out
            .println(new RepeatedDNASequencesSolution().findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /**
     * 使用两个set，一个保存已经遍历过的字符串，一个保存已经出现过的
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {

        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        Set<String> history = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String curr = s.substring(i, i + 10);
            if (history.contains(curr)) {
                ans.add(curr);
            }
            history.add(curr);
        }

        return new ArrayList<>(ans);
    }

    /**
     * 穷举法：超时无法ac
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        Set<String> ans = new HashSet<>();

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String pre = map.get(i);
            if (pre == null) {
                pre = s.substring(i, i + 10);
                map.put(i, pre);
            }
            for (int j = i + 1; j < s.length() - 9; j++) {
                String curr = map.get(j);
                if (curr == null) {
                    curr = s.substring(j, j + 10);
                    map.put(j, curr);
                }
                if (pre.equals(curr)) {
                    ans.add(pre);
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
