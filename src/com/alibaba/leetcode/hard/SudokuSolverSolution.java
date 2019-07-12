package com.alibaba.leetcode.hard;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the digits 1-9 must occur exactly once in each
 * column. Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid. Empty cells
 * are indicated by the character '.'.
 * 
 * Note:
 * 
 * The given board contain only digits 1-9 and the character '.'. You may assume that the given Sudoku puzzle will have
 * a single unique solution. The given board size is always 9x9.
 * 
 * 
 * @author wang
 * @date 2019/07/11
 */
public class SudokuSolverSolution {

    public static void main(String[] args) {

        char[][] board = new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolverSolution().solveSudoku(board);

    }

    /**
     * 回溯法
     * 
     * @param board
     */
    public void solveSudoku(char[][] board) {

        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }

        backTrack(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean backTrack(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row,
        int col) {

        if (col == board[0].length) {
            col = 0;
            row++;
            if (board.length == row) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
                boolean canPlace = !rowUsed[row][i] && !colUsed[col][i] && !boxUsed[row / 3][col / 3][i];
                if (canPlace) {
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    boxUsed[row / 3][col / 3][i] = true;
                    board[row][col] = (char)(i + '0');

                    if (backTrack(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }

                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    boxUsed[row / 3][col / 3][i] = false;
                    board[row][col] = '.';
                }
            }
        } else {
            return backTrack(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }

        return false;
    }
}
