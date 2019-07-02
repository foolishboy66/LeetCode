package com.alibaba.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written as II in Roman numeral, just two one's
 * added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which
 * is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.  X can be placed before L (50) and C (100) to make 40 and
 * 90.  C can be placed before D (500) and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * Input: "III" Output: 3 Example 2:
 * 
 * Input: "IV" Output: 4 Example 3:
 * 
 * Input: "IX" Output: 9 Example 4:
 * 
 * Input: "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3. Example 5:
 * 
 * Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * @author wang
 * @date 2019/07/01
 */
public class RomanToIntegerSolution {

    public static void main(String[] args) {

        System.out.println(new RomanToIntegerSolution().romanToInt("III"));
        System.out.println(new RomanToIntegerSolution().romanToInt("IV"));
        System.out.println(new RomanToIntegerSolution().romanToInt("V"));
        System.out.println(new RomanToIntegerSolution().romanToInt("LVIII"));
        System.out.println(new RomanToIntegerSolution().romanToInt("MCMXCIV"));
    }

    /**
     * 利用查找hashmap，遍历字符串，预先多读入一位，能在map中找到则说明就是这个值，累加各个结果即可
     * 
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        int[] table = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < table.length; i++) {
            map.put(values[i], table[i]);
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            String tmp1 = s.charAt(i) + "";
            String tmp2 = null;
            if (i < s.length() - 1) {
                tmp2 = s.charAt(i) + "" + s.charAt(i + 1);
            }
            if (tmp2 != null && map.containsKey(tmp2)) {
                num += map.get(tmp2);
                i++;
            } else if (map.containsKey(tmp1)) {
                num += map.get(tmp1);
            }
        }

        return num;
    }
}
