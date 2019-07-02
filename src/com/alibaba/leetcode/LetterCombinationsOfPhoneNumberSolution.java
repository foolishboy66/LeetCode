package com.alibaba.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 * 
 * 
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * 
 * @author wang
 * @date 2019/07/02
 */
public class LetterCombinationsOfPhoneNumberSolution {

    public static void main(String[] args) {

        System.out.println(new LetterCombinationsOfPhoneNumberSolution().letterCombinations("23"));
    }

    /**
     * 回溯法
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        backTrack("", digits, list, map);
        return list;
    }

    private void backTrack(String combine, String nextStr, List<String> output, Map<String, String> map) {

        if (nextStr.length() == 0) {
            output.add(combine);
        } else {
            String s = nextStr.substring(0, 1);
            String val = map.get(s);
            for (int i = 0; i < val.length(); i++) {
                backTrack(combine + val.substring(i, i + 1), nextStr.substring(1), output, map);
            }
        }

    }

}
