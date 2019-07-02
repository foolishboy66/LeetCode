package com.alibaba.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 
 * @author wang
 * @date 2019/07/01
 */
public class Sum3Solution {

    public static void main(String[] args) {

        System.out.println(new Sum3Solution().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(new Sum3Solution().threeSum(new int[] {7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5,
            7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1,
            -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14,
            -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8,
            6, -13, 14, -2, -5, -11, 1, 3, -6}));
        System.out.println(new Sum3Solution().threeSum2(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(new Sum3Solution().threeSum2(new int[] {7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5,
            7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1,
            -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14,
            -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8,
            6, -13, 14, -2, -5, -11, 1, 3, -6}));
        System.out.println(new Sum3Solution().threeSum2(new int[] {-2, 0, 0, 2, 2}));
    }

    /**
     * 解法一：暴力穷举法，去重错误，无法AC
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return null;
        }
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    /**
     * 解法二：双指针法
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    // r-- 
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else if (sum < 0) {
                    // l++
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    l++;
                    r--;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
