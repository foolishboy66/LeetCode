package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b +
 * c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * 
 * @author wang
 * @date 2019/07/03
 */
public class Sum4Solution {

    public static void main(String[] args) {

        System.out.println(new Sum4Solution().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(new Sum4Solution().fourSum(new int[] {-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(new Sum4Solution().fourSum(new int[] {-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9));
    }

    /**
     * 将四数之和转化为三数之和
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return output;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
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
                        output.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }

        return new ArrayList<>(new HashSet<>(output));
    }
}
