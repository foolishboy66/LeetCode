package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n! inclusive. Example 1:
 * 
 * Input: n = 3, k = 3 Output: "213" Example 2:
 * 
 * Input: n = 4, k = 9 Output: "2314"
 * 
 * 
 * @author wang
 * @date 2019/07/17
 */
public class PermutationSequenceSolution {

    public static void main(String[] args) {

        System.out.println(new PermutationSequenceSolution().getPermutation(3, 3));
    }

    /**
     * 第i个数，有m = (n-i-1)!种排列，如果k>m，说明第k个排列在后边的排列中，直接跳过当前数的所有子序列即可
     * 
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {

        if (n <= 0) {
            return null;
        } else if (n == 1) {
            return n + "";
        }

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        boolean[] visited = new boolean[nums.length];

        List<String> res = new ArrayList<>();
        backTrack(nums, 0, res, new ArrayList<>(), visited, k);

        if (res.isEmpty()) {
            return null;
        }
        return res.get(0);
    }

    private int factorial(int n) {

        int ans = 1;
        while (n > 0) {
            ans *= n;
            n--;
        }
        return ans;
    }

    private void backTrack(int[] nums, int len, List<String> res, List<Integer> list, boolean[] visited, int k) {

        if (len == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : list) {
                sb.append(num);
            }
            res.add(sb.toString());
            return;
        }

        int factorial = factorial(nums.length - len - 1);
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (factorial < k) {
                    k -= factorial;
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                backTrack(nums, len + 1, res, list, visited, k);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
