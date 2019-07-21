package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Example 1:
 * 
 * Input: [   [1,1,1],   [1,0,1],   [1,1,1] ]
 * 
 * Output: [   [1,0,1],   [0,0,0],   [1,0,1] ]
 * 
 * Example 2:
 * 
 * Input: [   [0,1,2,0],   [3,4,5,2],   [1,3,1,5] ]
 * 
 * Output: [   [0,0,0,0],   [0,4,5,0],   [0,3,1,0] ] Follow up:
 * 
 * A straight forward solution using O(mn) space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 * 
 * @author wang
 * @date 2019/07/20
 */
public class SetMatrixZeroesSolution {
    
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {1,1,1},{1,0,1}, {1,1,1}
        };
        new SetMatrixZeroesSolution().setZeroes(matrix);
        System.out.println(ConvertUtils.intArrayToStr(matrix));
    }

    public void setZeroes(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowZero = new boolean[row]; 
        boolean[] colZero = new boolean[col];
        
        for(int i=0; i<row;i++) {
            for(int j=0;j<col;j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
