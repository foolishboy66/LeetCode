package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5] Example 2:
 * 
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * @author wang
 * @date 2019/07/16
 */
public class SpiralMatrixSolution {

    public static void main(String[] args) {

        System.out.println(new SpiralMatrixSolution().spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out
            .println(new SpiralMatrixSolution().spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}

        }));
    }

    /**
     * 顺序访问，转一圈，遇到行尾、列尾或访问过的元素时需要转向
     * 
     * 行转向矩阵：[0,1,0,-1]
     * 
     * 列转向矩阵：[1,0,-1,0]
     * 
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];
        int[] rd = new int[] {0, 1, 0, -1};
        int[] cd = new int[] {1, 0, -1, 0};

        List<Integer> ans = new ArrayList<>();
        int di = 0;
        int rr = 0;
        int cc = 0;
        for (int i = 0; i < row * col; i++) {
            ans.add(matrix[rr][cc]);
            visited[rr][cc] = true;

            int r = rr + rd[di];
            int c = cc + cd[di];
            if (r < row && r >= 0 && c < col && c >= 0 && !visited[r][c]) {
                // 未到达边界，继续遍历
                rr = r;
                cc = c;
            } else {
                // 到达边界，需要转向
                di = (di + 1) % 4;
                rr += rd[di];
                cc += cd[di];
            }
        }

        return ans;
    }
}
