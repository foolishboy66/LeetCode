package com.alibaba.leetcode.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
 * is more subtle.
 * 
 * 
 * @author wang
 * @date 2019/07/16
 */
public class MaximumSubarraySolution {

    public static void main(String[] args) {

        System.out.println(new MaximumSubarraySolution().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
