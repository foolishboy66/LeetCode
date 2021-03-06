package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate the array counting
 * number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's. Could you
 * come up with a one-pass algorithm using only constant space?
 * 
 * 
 * @author wang
 * @date 2019/07/20
 */
public class SortColorsSolution {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 0, 2, 1, 1, 0};
        new SortColorsSolution().sortColors(nums);
        System.out.println(ConvertUtils.intArrayToStr(nums));
    }

    public void sortColors(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            while (c > 0) {
                nums[j++] = i;
                c--;
            }
        }
    }
}
