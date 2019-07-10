package com.alibaba.leetcode.middle;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * 
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * 
 * Output: -1
 * 
 * 
 * @author wang
 * @date 2019/07/09
 */
public class SearchRotatedSortedArraySolution {

    public static void main(String[] args) {

        System.out.println(new SearchRotatedSortedArraySolution().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchRotatedSortedArraySolution().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < nums[r]) {
                // 右边有序
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
