package com.alibaba.leetcode.middle.s2;

import java.util.Arrays;

/**
 * 130. Surrounded Regions
 * 
 * 130. 被围绕的区域
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example:
 * 
 * X X X X
 * 
 * X O O X
 * 
 * X X O X
 * 
 * X O X X
 * 
 * After running your function, the board should be:
 * 
 * X X X X
 * 
 * X X X X
 * 
 * X X X X
 * 
 * X O X X
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to
 * 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two
 * cells are connected if they are adjacent cells connected horizontally or vertically.
 * 
 * 
 * @author wang
 * @date 2019/07/31
 */
public class SurroundedRegionsSolution {

    public static void main(String[] args) {

        char[][] board =
            new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegionsSolution().solve(board);
        System.out.println(Arrays.asList(board));
    }

    /**
     * 思路：将与边缘上的'O'相连的所有'O'替换为'@'，然后将剩下的所有'O'替换为'X'，最后将'@'替换回'O'
     * 
     * @param board
     */
    public void solve(char[][] board) {

        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '@') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    /**
     * dfs将上下左右与边缘上的'O'连通的'O'替换为'@'
     * 
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@' || board[i][j] == 'X') {
            return;
        }

        board[i][j] = '@';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
