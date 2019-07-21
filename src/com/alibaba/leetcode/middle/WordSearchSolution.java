package com.alibaba.leetcode.middle;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true.
 * 
 * Given word = "SEE", return true.
 * 
 * Given word = "ABCB", return false.
 * 
 * 
 * @author wang
 * @date 2019/07/21
 */
public class WordSearchSolution {

    public static void main(String[] args) {

        System.out.println(new WordSearchSolution()
            .exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new WordSearchSolution()
            .exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new WordSearchSolution()
            .exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    /**
     * 回溯法：每次回溯中上下左右匹配
     * 
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int[][] dir = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backTrack(dir, i, j, visited, board, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrack(int[][] dir, int i, int j, boolean[][] visited, char[][] board, int k, String word) {

        if (k == word.length() - 1) {
            return word.charAt(k) == board[i][j];
        }

        if (word.charAt(k) == board[i][j]) {
            visited[i][j] = true;

            for (int m = 0; m < 4; m++) {
                int x = i + dir[m][0];
                int y = j + dir[m][1];
                if (x < board.length && y < board[0].length && x >= 0 && y >= 0 && !visited[x][y]) {
                    if (backTrack(dir, x, y, visited, board, k + 1, word)) {
                        return true;
                    }
                }
            }

            visited[i][j] = false;
        }

        return false;
    }
}