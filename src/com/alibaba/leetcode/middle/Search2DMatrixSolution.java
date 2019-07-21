package com.alibaba.leetcode.middle;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of
 * the previous row. Example 1:
 * 
 * Input: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 3
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 13
 * 
 * Output: false
 * 
 * 
 * @author wang
 * @date 2019/07/20
 */
public class Search2DMatrixSolution {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new Search2DMatrixSolution().searchMatrix(new int[][] {{1}}, 1));
        System.out.println(new Search2DMatrixSolution().searchMatrix(matrix, 3));
        System.out.println(new Search2DMatrixSolution().searchMatrix(matrix, 13));
    }

    /**
     * 先确定行，然后二分查找
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = matrix.length - 1;
        while (matrix[i][0] > target && i > 0) {
            i--;
        }

        return binarySearch(matrix[i], target);
    }

    private boolean binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int num = nums[mid];
            if (target == num) {
                return true;
            } else if (target > num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
