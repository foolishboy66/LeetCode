package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 * 
 * 
 * @author wang
 * @date 2019/07/08
 */
public class NextPermutationSolution {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3, 5, 6, 8};
        new NextPermutationSolution().nextPermutation(nums);
        System.out.println(ConvertUtils.intArrayToStr(nums));

        int[] nums2 = new int[] {1, 2};
        new NextPermutationSolution().nextPermutation(nums2);
        System.out.println(ConvertUtils.intArrayToStr(nums2));

        int[] nums3 = new int[] {1, 3, 2};
        new NextPermutationSolution().nextPermutation(nums3);
        System.out.println(ConvertUtils.intArrayToStr(nums3));

        int[] nums4 = new int[] {5, 4, 7, 5, 3, 2};
        new NextPermutationSolution().nextPermutation(nums4);
        System.out.println(ConvertUtils.intArrayToStr(nums4));
    }

    /**
     * 思路：1、从右往左遍历数组，保证右边是降序排列的，降序排列的数组没有更小的排列。
     * 
     * 2、直到找到无法降序的元素，从右往左找到比该元素大的第一个数，交换两者位置
     * 
     * 3、因为该数右边是降序排列的，交换之后也还是降序排列的，要获取下一个最小的数，直接将该数右边部分反转顺序即可
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        if (nums.length <= 2) {
            reverse(nums, 0);
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {

        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
