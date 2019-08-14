package com.alibaba.leetcode.middle.s2;

/**
 * 200. Number of Islands
 * 
 * 200. 岛屿数量
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 11110
 * 
 * 11010
 * 
 * 11000
 * 
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input:
 * 
 * 11000
 * 
 * 11000
 * 
 * 00100
 * 
 * 00011
 * 
 * Output: 3
 * 
 * 
 * @author wang
 * @date 2019/08/14
 */
public class NumberOfIslandsSolution {

    public static void main(String[] args) {

        System.out.println(new NumberOfIslandsSolution().numIslands(new char[][] {{'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    /**
     * dfs，所有相连的1的个数即为解
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
