package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * Example:
 * 
 * Input: n = 4, k = 2 Output:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 
 * @author wang
 * @date 2019/07/21
 */
public class CombinationsSolution {

    public static void main(String[] args) {

        System.out.println(new CombinationsSolution().combine(4, 2));
    }

    /**
     * 回溯法
     * 
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums, k, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int i, int[] nums, int k, List<List<Integer>> res, List<Integer> tmp) {

        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
        }
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(j + 1, nums, k, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
