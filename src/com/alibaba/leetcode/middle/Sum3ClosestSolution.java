package com.alibaba.leetcode.middle;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author wang
 * @date 2019/07/02
 */
public class Sum3ClosestSolution {

    public static void main(String[] args) {

        System.out.println(new Sum3ClosestSolution().threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
        System.out.println(new Sum3ClosestSolution().threeSumClosest(new int[] {1, 1, -1, -1, 3}, -1));

        System.out.println(new Sum3ClosestSolution().threeSumClosest2(new int[] {-1, 2, 1, -4}, 1));
        System.out.println(new Sum3ClosestSolution().threeSumClosest2(new int[] {1, 1, -1, -1, 3}, -1));
    }

    /**
     * 解法一：暴力穷举法
     * 
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return 0;
        }

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 解法二：双指针法
     * 
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum > target) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
            }
        }

        return ans;
    }
}
