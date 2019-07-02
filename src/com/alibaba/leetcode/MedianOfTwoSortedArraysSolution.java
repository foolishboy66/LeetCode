package com.alibaba.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author wang
 * @date 2019/06/27
 */
public class MedianOfTwoSortedArraysSolution {

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new MedianOfTwoSortedArraysSolution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new MedianOfTwoSortedArraysSolution().findMedianSortedArrays(new int[] {}, new int[] {1, 2, 3}));
        System.out.println(new MedianOfTwoSortedArraysSolution().findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }

    /**
     * 常规的做法是合并两个数组为一个有序数组，直接取出中位数，这样复杂度为O(m+n)
     * 
     * <p>
     * 但是要求时间复杂度为O(log(m+n))，只能采用二分法。思路是：若两个有序数组的长度和为奇数，中位数为第(m+n)/2个数，
     * </p>
     * <p>
     * 若为偶数，则中位数为序号分别为(m+n)/2、((m+n)/2+1)的两个数之和的平均值，问题就变成了查找第(m+n)/2个数，采用二分法查找即可
     * </p>
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) {
            throw new IllegalArgumentException("Array nums1 and nums2 can't be both empty.");
        }

        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2;

        if ((m + n) % 2 == 0) {
            return (findNth(nums1, nums2, 0, 0, m, n, k) + findNth(nums1, nums2, 0, 0, m, n, k + 1)) / 2.0;
        } else {
            return findNth(nums1, nums2, 0, 0, m, n, k + 1);
        }
    }

    private int findNth(int[] nums1, int[] nums2, int start1, int start2, int len1, int len2, int n) {

        if (len1 > len2) {
            return findNth(nums2, nums1, start2, start1, len2, len1, n);
        }

        if (len1 == 0) {
            return nums2[start2 + n - 1];
        }
        if (n == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int p = Math.min(n / 2, len1);
        int q = n - p;
        if (nums1[start1 + p - 1] < nums2[start2 + q - 1]) {
            return findNth(nums1, nums2, start1 + p, start2, len1 - p, len2, n - p);
        } else if (nums1[start1 + p - 1] > nums2[start2 + q - 1]) {
            return findNth(nums1, nums2, start1, start2 + q, len1, len2 - q, n - q);
        } else {
            return nums1[start1 + p - 1];
        }
    }

}
