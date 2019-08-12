package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 189. Rotate Array
 * 
 * 189. 旋转数组
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * 
 * Output: [5,6,7,1,2,3,4]
 * 
 * Explanation:
 * 
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * 
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * 
 * Output: [3,99,-1,-100]
 * 
 * Explanation:
 * 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * 
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem. Could you do
 * it in-place with O(1) extra space?
 * 
 * @author wang
 * @date 2019/08/12
 */
public class RotateArraySolution {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        new RotateArraySolution().rotate(nums, 3);
        System.out.println(ConvertUtils.intArrayToStr(nums));

        int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7};
        new RotateArraySolution().rotate2(nums2, 3);
        System.out.println(ConvertUtils.intArrayToStr(nums2));

        int[] nums3 = new int[] {1, 2, 3, 4, 5, 6, 7};
        new RotateArraySolution().rotate3(nums3, 3);
        System.out.println(ConvertUtils.intArrayToStr(nums3));
    }

    /**
     * 解法一：每次只移动一个，执行k次
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        for (int j = 0; j < k; j++) {
            int n = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = n;
        }
    }

    /**
     * 解法二：环状替换
     * 
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {

        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        for (int i = 0, count = 0; count < len; i++) {
            int start = i;
            int pre = nums[start];
            do {
                int next = (start + k) % len;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                count++;
                start = next;
            } while (start != i);

        }
    }

    /**
     * 解法二：数组末尾后k个数会移动到数据前边来，可以先将整个数据反转，然后将前k个、以及k之后的子数组依次反转
     * 
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {

        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
