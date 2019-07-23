package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: [1,2,2]
 * 
 * Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * 
 * @author wang
 * @date 2019/07/23
 */
public class SubsetsIISolution {

    public static void main(String[] args) {

        System.out.println(new SubsetsIISolution().subsetsWithDup(new int[] {1, 2, 2}));
        System.out.println(new SubsetsIISolution().subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
    }

    /**
     * 回溯法：先排序，在获取所有的子序列的过程中遇到相同元素跳过以去重
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        backTrack(res, 0, nums, new ArrayList<>());

        return res;
    }

    private void backTrack(List<List<Integer>> res, int start, int[] nums, List<Integer> temp) {

        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            backTrack(res, i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
