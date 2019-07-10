package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * 
 * Output: [3,4]
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * 
 * Output: [-1,-1]
 * 
 * 
 * @author wang
 * @date 2019/07/09
 */
public class FindFirstLastPositionInSortedArraySolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.intArrayToStr(
            new FindFirstLastPositionInSortedArraySolution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(ConvertUtils.intArrayToStr(
            new FindFirstLastPositionInSortedArraySolution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {

        int index = binSearch(nums, target);
        if (index == -1) {
            return new int[] {-1, -1};
        }

        int min = index;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] == nums[i]) {
                min--;
            }
        }
        int max = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                max++;
            }
        }

        return new int[] {min, max};
    }

    private int binSearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
