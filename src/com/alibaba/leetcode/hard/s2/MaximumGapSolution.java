package com.alibaba.leetcode.hard.s2;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 * 
 * 164. 最大间距
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * 
 * Input: [3,6,9,1]
 * 
 * Output: 3
 * 
 * Explanation: The sorted form of the array is [1,3,6,9], either   (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * 
 * Input: [10]
 * 
 * Output: 0
 * 
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 
 * Try to solve it in linear time/space.
 * 
 * 
 * @author wang
 * @date 2019/08/08
 */
public class MaximumGapSolution {

    public static void main(String[] args) {

        System.out.println(new MaximumGapSolution().maximumGap(new int[] {10}));
        System.out.println(new MaximumGapSolution().maximumGap(new int[] {3, 6, 9, 1}));

        System.out.println(new MaximumGapSolution().maximumGap2(new int[] {10}));
        System.out.println(new MaximumGapSolution().maximumGap2(new int[] {3, 6, 9, 1}));
    }

    /**
     * 解法一：先排序，在求解
     * 
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }

        return max;
    }

    /**
     * 解法二：基数排序后求解
     * 
     * @param nums
     * @return
     */
    public int maximumGap2(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int[] temp = new int[nums.length];
        for (int exp = 1; maxVal / exp > 0; exp = exp * 10) {
            int[] buckets = new int[10];
            for (int i = 0; i < nums.length; i++) {
                buckets[nums[i] / exp % 10]++;
            }

            for (int i = 1; i < buckets.length; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                temp[--buckets[nums[i] / exp % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }

        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }

        return max;
    }
}
