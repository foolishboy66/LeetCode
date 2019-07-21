package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3]
 * 
 * Output: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 * 
 * 
 * @author wang
 * @date 2019/07/21
 */
public class SubsetsSolution {

    public static void main(String[] args) {

        System.out.println(new SubsetsSolution().subsets(new int[] {1, 2, 3}));
    }

    /**
     * 回溯法
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backTrack(0, nums, res, new ArrayList<>());

        return res;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> res, List<Integer> tmp) {

        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
