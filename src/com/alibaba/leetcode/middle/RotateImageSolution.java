package com.alibaba.leetcode.middle;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate
 * another 2D matrix and do the rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 * rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2], [9,6,3] ] Example 2:
 * 
 * Given input matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16] ],
 * 
 * rotate the input matrix in-place such that it becomes: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7,10,11] ]
 * 
 * 
 * @author wang
 * @date 2019/07/15
 */
public class RotateImageSolution {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImageSolution().rotate(matrix);
        System.out.println(matrix);

        int[][] matrix2 = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImageSolution().rotate2(matrix2);
        System.out.println(matrix2);
    }

    /**
     * 解法一： a[i][j]=a[n-j][i]
     * 
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int len = matrix.length;
        int[][] nums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[i][j] = matrix[len - j - 1][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = nums[i][j];
            }
        }
    }

    /**
     * 解法二： 行变列，列变行，然后行逆序
     * 
     * @param matrix
     */
    public void rotate2(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

}
