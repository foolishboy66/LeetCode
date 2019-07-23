package com.alibaba.leetcode.hard;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input: [ ["1","0","1","0","0"], ["1","0","1","1","1"], ["1","1","1","1","1"], ["1","0","0","1","0"] ]
 * 
 * Output: 6
 * 
 * 
 * @author wang
 * @date 2019/07/22
 */
public class MaximalRectangleSolution {

    public static void main(String[] args) {

        System.out.println(new MaximalRectangleSolution().maximalRectangle(new char[][] {{'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    /**
     * 动态规划：dp[i][j]存储到第i行的第j个元素的最大矩形宽度，然后计算以matrix[i][j]作为右下角的矩阵的最大面积
     * 
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    maxArea = Math.max(maxArea, (i - k + 1) * width);
                }
            }
        }

        return maxArea;
    }
}
