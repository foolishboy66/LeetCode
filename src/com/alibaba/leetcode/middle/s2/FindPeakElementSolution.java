package com.alibaba.leetcode.middle.s2;

/**
 * 162. 寻找峰值
 * 
 * 162. Find Peak Element
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * 
 * Output: 2
 * 
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * 
 * Output: 1 or 5
 * 
 * Explanation: Your function can return either index number 1 where the peak element is 2,   or index number 5 where
 * the peak element is 6.
 * 
 * Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 * 
 * @author wang
 * @date 2019/08/08
 */
public class FindPeakElementSolution {

    public static void main(String[] args) {

        System.out.println(new FindPeakElementSolution().findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4}));
        System.out.println(new FindPeakElementSolution().findPeakElement(new int[] {1, 2}));
        System.out.println(new FindPeakElementSolution().findPeakElement(new int[] {2, 1}));
    }

    /**
     * 二分法：每次计算mid，如果mid是递增的，则结果在mid右边；如果mid是递减的，则结果在mid左边
     * 
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }

        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                // 降序，结果在mid左边
                r = mid;
            } else {
                // 升序，结果在mid右边
                l = mid + 1;
            }
        }

        return l;
    }

    /**
     * 解法一：暴力法，需要注意边界情况
     * 
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
