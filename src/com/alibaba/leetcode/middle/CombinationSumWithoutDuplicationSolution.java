package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ] Example
 * 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [   [1,2,2],   [5] ]
 * 
 * 
 * @author wang
 * @date 2019/07/12
 */
public class CombinationSumWithoutDuplicationSolution {

    public static void main(String[] args) {

        System.out.println(
            new CombinationSumWithoutDuplicationSolution().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
        System.out
            .println(new CombinationSumWithoutDuplicationSolution().combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> output = new ArrayList<>();
        backTrack(candidates, target, 0, output, new ArrayList<>());

        return output;
    }

    /**
     * 回溯法
     * 
     * @param candidates
     * @param target
     * @param start
     * @param output
     * @param arrayList
     */
    private void backTrack(int[] candidates, int target, int start, List<List<Integer>> output, List<Integer> result) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            output.add(new ArrayList<>(result));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // 此处要避免重复解，且不能漏掉处于不同位置的相同数的可能
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target < candidates[i]) {
                break;
            }

            result.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, output, result);
            result.remove(result.size() - 1);
        }

    }

}
