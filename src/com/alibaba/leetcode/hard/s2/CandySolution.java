package com.alibaba.leetcode.hard.s2;

/**
 * 135. Candy
 * 
 * 135. 分发糖果
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. What is
 * the minimum candies you must give?
 * 
 * Example 1:
 * 
 * Input: [1,0,2]
 * 
 * Output: 5
 * 
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * 
 * Example 2:
 * 
 * Input: [1,2,2]
 * 
 * Output: 4
 * 
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively. The third child
 * gets 1 candy because it satisfies the above two conditions.
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class CandySolution {

    public static void main(String[] args) {

        System.out.println(new CandySolution().candy(new int[] {1, 0, 2}));
        System.out.println(new CandySolution().candy(new int[] {1, 2, 2}));
    }

    /**
     * 数组递增时加一即可，可以实现从左往右 一次扫描，然后从右往左一次扫描，去各位的最大值即可
     * 
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {

        int total = 0;
        if (ratings.length == 0) {
            return total;
        }
        int[] dp1 = new int[ratings.length];
        for (int i = 0; i < dp1.length; i++) {
            dp1[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }

        int[] dp2 = new int[ratings.length];
        for (int i = 0; i < dp2.length; i++) {
            dp2[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            total += Math.max(dp1[i], dp2[i]);
        }

        return total;
    }

}
