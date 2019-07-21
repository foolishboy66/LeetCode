package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the
 * new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * 
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3
 * and 3 respectively.
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
 * @date 2019/07/21
 */
public class RemoveDuplicatesFromSortedArrayIISolution {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int len = new RemoveDuplicatesFromSortedArrayIISolution().removeDuplicates(nums);
        System.out.println(len);
        System.out.println(ConvertUtils.intArrayToStr(nums, len));

        int[] nums2 = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len2 = new RemoveDuplicatesFromSortedArrayIISolution().removeDuplicates(nums2);
        System.out.println(len2);
        System.out.println(ConvertUtils.intArrayToStr(nums2, len2));
    }

    /**
     * 双指针法
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            } else if (count < 2) {
                i++;
                nums[i] = nums[j];
                count++;
            }
        }

        return i + 1;
    }
}
