package com.alibaba.leetcode.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: [1,3,5,6], 2
 * 
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * Input: [1,3,5,6], 7
 * 
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * Input: [1,3,5,6], 0
 * 
 * Output: 0
 * 
 * 
 * @author wang
 * @date 2019/07/10
 */
public class SearchInsertPositionSolution {

    public static void main(String[] args) {
        System.out.println(new SearchInsertPositionSolution().searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(new SearchInsertPositionSolution().searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPositionSolution().searchInsert(new int[] {1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPositionSolution().searchInsert(new int[] {1, 3, 5, 6}, 0));
    }

    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
