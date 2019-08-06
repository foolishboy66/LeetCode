package com.alibaba.leetcode.middle.s2;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * 153. 寻找旋转排序数组中的最小值
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * Input: [3,4,5,1,2]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,5,6,7,0,1,2]
 * 
 * Output: 0
 * 
 * 
 * @author wang
 * @date 2019/08/06
 */
public class FindMinimumInRotatedSortedArraySolution {

    public static void main(String[] args) {

        System.out.println(new FindMinimumInRotatedSortedArraySolution().findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(new FindMinimumInRotatedSortedArraySolution().findMin(new int[] {3, 4, 5, 1, 2}));

        System.out.println(new FindMinimumInRotatedSortedArraySolution().findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new FindMinimumInRotatedSortedArraySolution().findMin(new int[] {4}));
    }

    /**
     * 二分法
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid == l || mid == r) {
                return Math.min(nums[l], nums[r]);
            }
            if (nums[mid] > nums[l]) {
                // 左边有序
                if (nums[mid] < nums[r]) {
                    return nums[l];
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < nums[r]) {
                    // 右边有序
                    r = mid;
                } else {
                    return r;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
}
