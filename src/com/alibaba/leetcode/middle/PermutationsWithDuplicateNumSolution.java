package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * Example:
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author wang
 * @date 2019/07/14
 */
public class PermutationsWithDuplicateNumSolution {

    public static void main(String[] args) {

        System.out.println(new PermutationsWithDuplicateNumSolution().permuteUnique(new int[] {1, 1, 2}));
        System.out.println(new PermutationsWithDuplicateNumSolution().permuteUnique(new int[] {1, 2, 3}));

        System.out.println(new PermutationsWithDuplicateNumSolution().permuteUnique2(new int[] {1, 1, 2}));
        System.out.println(new PermutationsWithDuplicateNumSolution().permuteUnique2(new int[] {1, 2, 3}));
        System.out.println(new PermutationsWithDuplicateNumSolution().permuteUnique2(new int[] {3, 3, 0, 3}));

    }

    /**
     * 解法一：交换位置回溯，结果用set去重
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        sq(nums, 0, res);
        return new ArrayList<>(new HashSet<>(res));
    }

    /**
     * 解法二：不交换元素位置的回溯法
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, 0, ans, new ArrayList<>(), visited);
        return ans;
    }

    private void backTrack(int[] nums, int len, List<List<Integer>> ans, List<Integer> list, boolean[] visited) {

        if (len == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                backTrack(nums, len + 1, ans, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 回溯法
     * 
     * @param nums
     * @param k
     * @param res
     */
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
