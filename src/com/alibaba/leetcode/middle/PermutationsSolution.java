package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * 
 * @author wang
 * @date 2019/07/14
 */
public class PermutationsSolution {

    public static void main(String[] args) {

        System.out.println(new PermutationsSolution().permute(new int[] {1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        sq(nums, 0, res);
        return res;
    }

    private void sq(int[] nums, int k, List<List<Integer>> res) {

        if (k == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            swap(i, k, nums);
            sq(nums, k + 1, res);
            swap(k, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
