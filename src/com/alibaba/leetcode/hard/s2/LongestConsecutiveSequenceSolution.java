package com.alibaba.leetcode.hard.s2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 
 * 128. 最长连续序列
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * 
 * Output: 4
 * 
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * 
 * @author wang
 * @date 2019/07/31
 */
public class LongestConsecutiveSequenceSolution {

    public static void main(String[] args) {

        System.out
            .println(new LongestConsecutiveSequenceSolution().longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive(new int[] {0, -1}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive(new int[] {1, 2, 0, 1}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive(new int[] {1, 1}));

        System.out
            .println(new LongestConsecutiveSequenceSolution().longestConsecutive2(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive2(new int[] {0, -1}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive2(new int[] {1, 2, 0, 1}));
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive2(new int[] {1, 1}));
    }

    /**
     * 解法一：用hashSet存储数组，然后遍历每一个元素，分别往大或小的方向从数组中移除元素
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        int max = 1;
        for (Integer num : nums) {
            if (set.remove(num)) {
                int count = 1;
                int curr = num;
                while (set.remove(curr - 1)) {
                    curr--;
                }
                count += num - curr;
                curr = num;
                while (set.remove(curr + 1)) {
                    curr++;
                }
                count += curr - num;

                max = Math.max(max, count);
            }
        }

        return max;
    }

    /**
     * 解法一：先排序，然后求最大长度
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] != nums[i - 1] + 1) {
                max = Math.max(max, count);
                count = 1;
            } else {
                count++;
            }
        }
        max = Math.max(max, count);

        return max;
    }
}
