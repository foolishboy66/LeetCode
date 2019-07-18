package com.alibaba.leetcode.middle;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * 
 * @author wang
 * @date 2019/07/17
 */
public class SpiralMatrixIISolution {

    public static void main(String[] args) {

        int[][] matrix = new SpiralMatrixIISolution().generateMatrix(3);
        System.out.println(Arrays.asList(matrix));
    }

    public int[][] generateMatrix(int n) {

        if (n == 0) {
            return new int[][] {};
        }
        if (n == 1) {
            return new int[][] {{1}};
        }

        int[] rd = new int[] {0, 1, 0, -1};
        int[] cd = new int[] {1, 0, -1, 0};
        boolean[][] placed = new boolean[n][n];
        int di = 0;
        int r = 0;
        int c = 0;
        int[][] nums = new int[n][n];
        for (int i = 1; i <= n * n; i++) {
            placed[r][c] = true;
            nums[r][c] = i;
            int rr = r + rd[di];
            int cc = c + cd[di];
            if (rr >= 0 && rr < n && cc >= 0 && cc < n && !placed[rr][cc]) {
                r = rr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += rd[di];
                c += cd[di];
            }
        }
        return nums;
    }
}
