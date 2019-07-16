package com.alibaba.leetcode.middle;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index. Example
 * 2:
 * 
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what. Its maximum   jump
 * length is 0, which makes it impossible to reach the last index.
 * 
 * 
 * @author wang
 * @date 2019/07/16
 */
public class JumpGameSolution {

    public static void main(String[] args) {

        System.out.println(new JumpGameSolution().canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(new JumpGameSolution().canJump(new int[] {3, 2, 1, 0, 4}));
        System.out.println(new JumpGameSolution().canJump(new int[] {3, 2, 0, 0, 4}));

        System.out.println(new JumpGameSolution().canJump2(new int[] {2, 3, 1, 1, 4}));
        System.out.println(new JumpGameSolution().canJump2(new int[] {3, 2, 1, 0, 4}));
        System.out.println(new JumpGameSolution().canJump2(new int[] {3, 2, 0, 0, 4}));

        System.out.println(new JumpGameSolution().canJump3(new int[] {2, 3, 1, 1, 4}));
        System.out.println(new JumpGameSolution().canJump3(new int[] {3, 2, 1, 0, 4}));
        System.out.println(new JumpGameSolution().canJump3(new int[] {3, 2, 0, 0, 4}));
        System.out.println(new JumpGameSolution().canJump3(new int[] {2, 0, 0}));
    }

    /**
     * 解法三：对于为所有为0的数，看是否有办法跳过改下标，如果没有则为false
     * 
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        boolean canJumpZero = true;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                canJumpZero = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (j + nums[j] > i) {
                        canJumpZero = true;
                        break;
                    }
                }
                if (!canJumpZero) {
                    break;
                }
            }
        }

        return canJumpZero;
    }

    /**
     * 解法二：贪心算法，每次从后往前找到能到达该位置的最小下标，最快地结束循环
     * 
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int index = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= index) {
                index = i;
            }
        }

        return index == 0;
    }

    /**
     * 解法一：回溯法,会超时
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        boolean withOutZero = true;
        for (int num : nums) {
            if (num == 0) {
                withOutZero = false;
            }
        }
        if (withOutZero) {
            return true;
        }

        return backTrack(0, nums);
    }

    private boolean backTrack(int i, int[] nums) {

        if (i >= nums.length - 1) {
            return true;
        }
        int n = nums[i];
        for (int j = n; j >= 1; j--) {
            if (backTrack(i + j, nums)) {
                return true;
            }
        }

        return false;
    }
}
