package com.alibaba.leetcode.easy.s2;

/**
 * 171. Excel Sheet Column Number
 * 
 * 171. Excel表列序号
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * ...
 * 
 * Example 1:
 * 
 * Input: "A"
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: "AB"
 * 
 * Output: 28
 * 
 * Example 3:
 * 
 * Input: "ZY"
 * 
 * Output: 701
 * 
 * 
 * @author wang
 * @date 2019/08/10
 */
public class ExcelSheetColumnNumberSolution {

    public static void main(String[] args) {

        System.out.println(new ExcelSheetColumnNumberSolution().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumberSolution().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumberSolution().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {

        int exp = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - 'A' + 1;
            ans += n * exp;
            exp *= 26;
        }
        return ans;
    }
}
