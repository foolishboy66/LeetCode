package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * 
 * 120. 三角形最小路径和
 * 
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
 * below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the
 * triangle.
 * 
 * 
 * @author wang
 * @date 2019/07/29
 */
public class TriangleSolution {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        List<List<Integer>> triangle =
            Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(new TriangleSolution().minimumTotal(triangle));
        System.out.println(new TriangleSolution().minimumTotal2(triangle));
        System.out.println(new TriangleSolution().minimumTotal3(triangle));
    }

    /**
     * 解法三：自底向上的一维动态规划，每一次的结果只会用到上一次的结果，之前的可以丢弃
     * 
     * 动态方程为：dp[j] = min(dp[j], dp[j+1]) + triangle.get(i).get(j)
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {

        int rows = triangle.size();
        if (rows == 0) {
            return 0;
        }

        int[] dp = new int[rows];
        List<Integer> last = triangle.get(rows - 1);
        for (int i = 0; i < rows; i++) {
            dp[i] = last.get(i);
        }

        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curr.get(j);
            }
        }

        return dp[0];
    }

    /**
     * 解法二：二维动态规划 dp[i][j]表示到第i行第j列的最小路径和，
     * 
     * 则动态方程为 dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {

        int rows = triangle.size();
        if (rows == 0) {
            return 0;
        }

        int[][] dp = new int[rows][rows];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < rows; i++) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int preMin;
                if (j == 0) {
                    preMin = dp[i - 1][j];
                } else if (j == i) {
                    preMin = dp[i - 1][j - 1];
                } else {
                    preMin = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }

                dp[i][j] = curr.get(j) + preMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[rows - 1]) {
            min = Math.min(min, num);
        }

        return min;
    }

    /**
     * 解法一：回溯法，超时无法AC
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() == 0) {
            return 0;
        }
        backTrack(triangle, 0, 0, new ArrayList<>());

        return min;
    }

    private void backTrack(List<List<Integer>> triangle, int lastIndex, int level, List<Integer> temp) {

        if (level == triangle.size()) {
            min = Math.min(min, temp.stream().mapToInt(value -> value).sum());
            return;
        }

        List<Integer> curr = triangle.get(level);
        for (int i = 0; i < 2 && (lastIndex + i) < curr.size(); i++) {
            temp.add(curr.get(lastIndex + i));

            backTrack(triangle, lastIndex + i, level + 1, temp);

            temp.remove(temp.size() - 1);
        }

    }
}
