package com.alibaba.leetcode.hard;

/**
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * 
 * 
 * @author wang
 * @date 2019/07/16
 */
public class QueensNCountSolution {

    public static void main(String[] args) {

        System.out.println(new QueensNCountSolution().totalNQueens(4));
    }

    int count = 0;

    public int totalNQueens(int n) {

        int[] position = new int[n];
        backTrack(0, n, position);
        return count;
    }

    private void backTrack(int row, int n, int[] position) {

        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            position[row] = i;
            if (canPlace(row, i, position)) {
                backTrack(row + 1, n, position);
            }
        }
    }

    private boolean canPlace(int row, int col, int[] position) {

        for (int i = 0; i < row; i++) {
            if (position[i] == col || (row - i) == Math.abs(position[row] - position[i])) {
                return false;
            }
        }

        return true;
    }
}
