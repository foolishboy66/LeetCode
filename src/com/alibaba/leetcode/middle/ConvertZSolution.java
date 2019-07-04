package com.alibaba.leetcode.middle;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L C I R E T O E S I I G E D H N 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows); 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
 * 
 * L D R E O E I I E C I H N T S G
 * 
 * 
 * @author wang
 * @date 2019/06/28
 */
public class ConvertZSolution {

    public static void main(String[] args) {

        System.out.println(new ConvertZSolution().convert("LEETCODEISHIRING", 4));
        System.out.println(new ConvertZSolution().convert2("LEETCODEISHIRING", 4));
        System.out.println(new ConvertZSolution().convert("PAYPALISHIRING", 4));
        System.out.println(new ConvertZSolution().convert2("PAYPALISHIRING", 4));
    }

    /**
     * 解法一：遍历字符串按照z字形转为二维字符数组
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows == 1) {
            return s;
        }

        Character[][] table = new Character[numRows][2048];
        int column = 0;
        int row = 0;
        boolean down = true;
        int maxCol = 0;
        for (int i = 0; i < s.length(); i++) {
            if (row == numRows) {
                down = false;
                row--;
            } else if (row == 0) {
                down = true;
                if (column != 0) {
                    row++;
                }
            }
            if (down) {
                // 下降
                table[row++][column] = s.charAt(i);
            } else {
                // 上升
                table[--row][++column] = s.charAt(i);
                maxCol = Math.max(column, maxCol);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y <= maxCol; y++) {
                if (table[x][y] != null) {
                    sb.append(table[x][y]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 解法二：假设当前行数是r，总行数R，I(n)表示某行第n个字母在原字符串中的index，n从0开始：
     * 
     * r=1或r=R时，I(n+1) = I(n)+2(R-1)
     * 
     * 1<r<R时，
     * 
     * I(n+1) = I(n)+2(R-r) n为偶数时，
     *
     * I(n+1) = I(n)+2(r-1) n为奇数
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {

        if (s == null || s.length() < 1 || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length() + 1; i += 2 * (numRows - 1)) {
            sb.append(s.charAt(i - 1));
        }

        for (int i = 2; i < numRows; i++) {
            boolean even = false;
            for (int j = i; j < s.length() + 1; j += even ? (2 * (numRows - i)) : (2 * (i - 1))) {
                sb.append(s.charAt(j - 1));
                even = !even;
            }
        }

        for (int i = numRows; i < s.length() + 1; i += 2 * (numRows - 1)) {
            sb.append(s.charAt(i - 1));
        }

        return sb.toString();
    }
}
