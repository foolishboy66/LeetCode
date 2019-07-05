package com.alibaba.leetcode.easy;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new
 * length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4
 * respectively.
 * 
 * It doesn't matter what values are set beyond the returned length. Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the
 * caller as well.
 * 
 * Internally you can think of this:
 * 
 * // nums is passed in by reference. (i.e., without making a copy) int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller. // using the length returned by your
 * function, it prints the first len elements. for (int i = 0; i < len; i++) {     print(nums[i]); }
 * 
 * 
 * @author wang
 * @date 2019/07/05
 */
public class RemoveDuplicatesFromSortedArraySolution {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArraySolution().removeDuplicates2(nums));
        System.out.println(ConvertUtils.intArrayToStr(nums));

        int[] nums2 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArraySolution().removeDuplicates2(nums2));
        System.out.println(ConvertUtils.intArrayToStr(nums2));

        System.out.println(new RemoveDuplicatesFromSortedArraySolution().removeDuplicates(new int[] {1}));
    }

    /**
     * 解法一：逆序遍历，遇到相同的则顺序左移
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int start;
        for (int i = nums.length - 1; i >= 0; i--) {
            start = i;
            int n = 0;
            while (i > 0 && nums[i] == nums[i - 1]) {
                i--;
                n++;
            }
            if (n > 0) {
                shiftLeftNbit(nums, start + 1, n);
            }
            len++;
        }

        return len;
    }

    private void shiftLeftNbit(int[] nums, int start, int n) {

        for (int i = start; i < nums.length; i++) {
            nums[i - n] = nums[i];
        }
    }

    /**
     * 解法二：双指针法
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
