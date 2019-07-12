package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3] ] Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8, A solution set is: [   [2,2,2,2],   [2,3,3],   [3,5] ]
 * 
 * 
 * @author wang
 * @date 2019/07/12
 */
public class CombinationSumSolution {

    public static void main(String[] args) {

        System.out.println(new CombinationSumSolution().combinationSum(new int[] {2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

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
     * @param result
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
            if (target < candidates[i]) {
                break;
            }
            result.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, output, result);
            result.remove(result.size() - 1);
        }
    }

}
