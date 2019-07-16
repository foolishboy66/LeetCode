package com.alibaba.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/16
 */
public class QueensNSolution {

    public static void main(String[] args) {

        System.out.println(new QueensNSolution().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {

        int[] position = new int[n];
        List<List<String>> ans = new ArrayList<>();
        backTrack(0, n, ans, position);

        return ans;
    }

    private void backTrack(int row, int n, List<List<String>> ans, int[] position) {

        if (row == n) {
            // 结果存到ans中
            ans.add(getStrResult(position));
            return;
        }
        for (int i = 0; i < n; i++) {
            position[row] = i;
            if (canPlace(row, i, position)) {
                backTrack(row + 1, n, ans, position);
            }
        }
    }

    private List<String> getStrResult(int[] position) {

        List<String> res = new ArrayList<>();

        for (int index : position) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < position.length; i++) {
                if (index == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
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
