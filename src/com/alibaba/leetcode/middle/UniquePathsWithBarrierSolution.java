package com.alibaba.leetcode.middle;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: [   [0,0,0],   [0,1,0],   [0,0,0] ] Output: 2
 * 
 * Explanation: There is one obstacle in the middle of the 3x3 grid above. There are two ways to reach the bottom-right
 * corner: 1. Right -> Right -> Down -> Down 2. Down -> Down -> Right -> Right
 * 
 * 
 * @author wang
 * @date 2019/07/18
 */
public class UniquePathsWithBarrierSolution {

    public static void main(String[] args) {

        System.out.println(new UniquePathsWithBarrierSolution()
            .uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

        System.out.println(new UniquePathsWithBarrierSolution().uniquePathsWithObstacles(new int[][] {{1, 0}}));

        System.out.println(new UniquePathsWithBarrierSolution().uniquePathsWithObstacles(new int[][] {{0}, {1}}));
    }

    /**
     * 动态规划，需要考虑第一行和第一列中有障碍的情况
     * 
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = Math.abs(obstacleGrid[0][0] - 1);
        for (int i = 1; i < row; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], Math.abs(obstacleGrid[i][0] - 1));
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], Math.abs(obstacleGrid[0][i] - 1));
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
