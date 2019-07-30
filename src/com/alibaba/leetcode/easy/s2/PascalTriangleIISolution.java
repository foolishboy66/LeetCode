package com.alibaba.leetcode.easy.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * 
 * 119. 杨辉三角 II
 * 
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * 
 * Input: 3
 * 
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 
 * @author wang
 * @date 2019/07/29
 */
public class PascalTriangleIISolution {

    public static void main(String[] args) {

        System.out.println(new PascalTriangleIISolution().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        for (int num : dp[rowIndex]) {
            ans.add(num);
        }

        return ans;
    }
}
