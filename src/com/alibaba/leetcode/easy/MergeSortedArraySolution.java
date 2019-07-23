package com.alibaba.leetcode.easy;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough
 * space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * 
 * Example:
 * 
 * Input:
 * 
 * nums1 = [1,2,3,0,0,0], m = 3
 * 
 * nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 * @author wang
 * @date 2019/07/23
 */
public class MergeSortedArraySolution {

    public static void main(String[] args) {

        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        new MergeSortedArraySolution().merge(nums1, 3, new int[] {2, 5, 6}, 3);
        System.out.println(ConvertUtils.intArrayToStr(nums1));
    }

    /**
     * 归并排序的思想
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0 || (m + n) > nums1.length) {
            return;
        }
        int[] temp = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        for (int a = 0; a < temp.length; a++) {
            nums1[a] = temp[a];
        }
    }
}
