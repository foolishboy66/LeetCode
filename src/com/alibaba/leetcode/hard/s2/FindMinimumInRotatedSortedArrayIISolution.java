package com.alibaba.leetcode.hard.s2;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * 
 * 154. 寻找旋转排序数组中的最小值 II
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * Input: [1,3,5]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [2,2,2,0,1]
 * 
 * Output: 0
 * 
 * Note:
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * 
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 * @author wang
 * @date 2019/08/06
 */
public class FindMinimumInRotatedSortedArrayIISolution {

    public static void main(String[] args) {

        System.out.println(new FindMinimumInRotatedSortedArrayIISolution().findMin(new int[] {2, 2, 2, 0, 1}));
        System.out.println(new FindMinimumInRotatedSortedArrayIISolution().findMin2(new int[] {2, 2, 2, 0, 1}));
        System.out.println(new FindMinimumInRotatedSortedArrayIISolution().findMin2(new int[] {2}));
    }

    /**
     * 解法二：二分查找
     * 
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }
            int mid = (l + r) >> 1;
            if (mid == r || mid == l) {
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
                    return nums[r];
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * 解法一：暴力法
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        return min;
    }
}
