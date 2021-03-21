package com.alibaba.leetcode.middle.s2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * 
 * 215. 数组中的第K个最大元素
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * 
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * 
 * Output: 4
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * 
 * 
 * @author wang
 * @date 2019/08/15
 */
public class KthLargestElementInAnArraySolution {

    public static void main(String[] args) {

        System.out.println(new KthLargestElementInAnArraySolution().findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new KthLargestElementInAnArraySolution().findKthLargest2(new int[] {3, 2, 1, 5, 6, 4}, 2));
    }

    /**
     * 解法二：使用优先级队列，保证队列中只有k个最大的元素
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (Integer n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    /**
     * 解法一：先排序，再取值
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
