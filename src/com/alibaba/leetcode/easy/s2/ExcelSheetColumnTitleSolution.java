package com.alibaba.leetcode.easy.s2;

/**
 * 168. Excel Sheet Column Title
 * 
 * 168. Excel表列名称
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 
 * 2 -> B
 * 
 * 3 -> C
 * 
 * ...
 * 
 * 26 -> Z
 * 
 * 27 -> AA
 * 
 * 28 -> AB
 * 
 * ...
 * 
 * Example 1:
 * 
 * Input: 1
 * 
 * Output: "A"
 * 
 * Example 2:
 * 
 * Input: 28
 * 
 * Output: "AB"
 * 
 * Example 3:
 * 
 * Input: 701
 * 
 * Output: "ZY"
 * 
 * 
 * @author wang
 * @date 2019/08/09
 */
public class ExcelSheetColumnTitleSolution {

    public static void main(String[] args) {

        System.out.println(new ExcelSheetColumnTitleSolution().convertToTitle(1));
        System.out.println(new ExcelSheetColumnTitleSolution().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitleSolution().convertToTitle(701));
        System.out.println(new ExcelSheetColumnTitleSolution().convertToTitle(26));
        System.out.println(new ExcelSheetColumnTitleSolution().convertToTitle(52));
    }

    /**
     * 26进制：注意n要减一
     * 
     * @param n
     * @return
     */
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
