package com.alibaba.leetcode.middle.s2;

/**
 * 152. Maximum Product Subarray
 * 
 * 152. 乘积最大子序列
 * 
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has
 * the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4]
 * 
 * Output: 6
 * 
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * 
 * Input: [-2,0,-1]
 * 
 * Output: 0
 * 
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * 
 * 
 * @author wang
 * @date 2019/08/06
 */
public class MaximumProductSubarraySolution {

    public static void main(String[] args) {

        System.out.println(new MaximumProductSubarraySolution().maxProduct(new int[] {2, 3, -2, 4}));
        System.out.println(new MaximumProductSubarraySolution().maxProduct(new int[] {-2, 0, -1}));

        System.out.println(new MaximumProductSubarraySolution().maxProduct2(new int[] {2, 3, -2, 4}));
        System.out.println(new MaximumProductSubarraySolution().maxProduct2(new int[] {-2, 0, -1}));
    }

    /**
     * 动态规划的思想
     * 
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {

        int max = Integer.MIN_VALUE;
        int currMax = 1;
        int currMin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int a = currMax;
                currMax = currMin;
                currMin = a;
            }
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            max = Math.max(max, currMax);
        }

        return max;
    }

    /**
     * 暴力求解
     * 
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int ans = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                ans *= nums[j];
                max = Math.max(max, ans);
            }
        }

        return max;
    }
}
