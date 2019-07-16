package com.alibaba.leetcode.hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from
 * index 0 to 1, then 3 steps to the last index. Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * 
 * @author wang
 * @date 2019/07/14
 */
public class JumpGameIISolution {

    public static void main(String[] args) {

        System.out.println(new JumpGameIISolution().jump(new int[] {2, 3, 1, 1, 4}));
    }

    /**
     * 贪心算法：每次跳到能到达的最大位置
     * 
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int max = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                steps++;
            }
        }
        return steps;
    }
}
