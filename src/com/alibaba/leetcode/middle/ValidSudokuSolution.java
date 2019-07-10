package com.alibaba.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following
 * rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Example 1:
 * 
 * Input: [ ["5","3",".",".","7",".",".",".","."], ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."], ["8",".",".",".","6",".",".",".","3"], ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"], [".","6",".",".",".",".","2","8","."], [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"] ] Output: true Example 2:
 * 
 * <b> Input: [   ["8","3",".",".","7",".",".",".","."],   ["6",".",".","1","9","5",".",".","."],  
 * [".","9","8",".",".",".",".","6","."],   ["8",".",".",".","6",".",".",".","3"],  
 * ["4",".",".","8",".","3",".",".","1"],   ["7",".",".",".","2",".",".",".","6"],  
 * [".","6",".",".",".",".","2","8","."],   [".",".",".","4","1","9",".",".","5"],  
 * [".",".",".",".","8",".",".","7","9"] ]
 * 
 * Output: false Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since
 * there are two 8's in the top left 3x3 sub-box, it is invalid. Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable. Only the filled cells need to be
 * validated according to the mentioned rules. The given board contain only digits 1-9 and the character '.'. The given
 * board size is always 9x9.
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/10
 */
public class ValidSudokuSolution {

    public static void main(String[] args) {

        System.out.println(
            new ValidSudokuSolution().isValidSudoku(new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        System.out.println(
            new ValidSudokuSolution().isValidSudoku2(new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }

    /**
     * 解法一：暴力穷举法
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        String[] rows = new String[9];
        String[] cols = new String[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows[i] = ((rows[i] == null) ? "" : rows[i]) + board[i][j];
                cols[j] = ((cols[j] == null) ? "" : cols[j]) + board[i][j];
            }
        }
        for (String col : cols) {
            if (containsDuplicatedNumber(col)) {
                return false;
            }
        }
        for (String row : rows) {
            if (containsDuplicatedNumber(row)) {
                return false;
            }
        }

        String[] ss = new String[9];
        for (int i = 0; i < 9; i = i + 3) {
            ss[i] = rows[i].substring(0, 3) + rows[i + 1].substring(0, 3) + rows[i + 2].substring(0, 3);
            ss[i + 1] = rows[i].substring(3, 6) + rows[i + 1].substring(3, 6) + rows[i + 2].substring(3, 6);
            ss[i + 2] = rows[i].substring(6, 9) + rows[i + 1].substring(6, 9) + rows[i + 2].substring(6, 9);
        }
        for (String row : ss) {
            if (containsDuplicatedNumber(row)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsDuplicatedNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                Integer val = map.getOrDefault(s.charAt(i), 0);
                map.put(s.charAt(i), val + 1);
            }
        }
        for (Integer val : map.values()) {
            if (val > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法二：一次迭代，用map数组保存每一行、每一列、每一个单元格中出现的数字次数
     * 
     * @param board
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku2(char[][] board) {

        Map<Character, Integer>[] rows = new HashMap[9];
        Map<Character, Integer>[] cols = new HashMap[9];
        Map<Character, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' != board[i][j]) {
                    char num = board[i][j];
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);

                    int k = (i / 3) * 3 + j / 3;
                    boxes[k].put(num, boxes[k].getOrDefault(num, 0) + 1);

                    if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[k].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
