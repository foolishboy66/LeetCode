package com.alibaba.leetcode.middle;

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
 * 90.  C can be placed before D (500) and M (1000) to make 400 and 900. Given an integer, convert it to a roman
 * numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * Input: 3 Output: "III" Example 2:
 * 
 * Input: 4 Output: "IV" Example 3:
 * 
 * Input: 9 Output: "IX" Example 4:
 * 
 * Input: 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example 5:
 * 
 * Input: 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * @author wang
 * @date 2019/07/01
 */
public class IntegerToRomanSolution {

    public static void main(String[] args) {

        System.out.println(new IntegerToRomanSolution().intToRoman(3));
        System.out.println(new IntegerToRomanSolution().intToRoman(4));
        System.out.println(new IntegerToRomanSolution().intToRoman(5));
        System.out.println(new IntegerToRomanSolution().intToRoman(58));
        System.out.println(new IntegerToRomanSolution().intToRoman(1994));
    }

    /**
     * 使用hash表记录几个特殊的值
     * 
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("num should be within the range from 1 to 3999!");
        }

        int[] table = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length && num > 0; i++) {
            int a = num / table[i];
            if (a == 0) {
                continue;
            }
            for (int j = 0; j < a; j++) {
                sb.append(values[i]);
            }
            num -= a * table[i];
        }

        return sb.toString();
    }

}
