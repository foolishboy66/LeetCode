package com.alibaba.leetcode.hard.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 149.Max Points on a Line
 * 
 * 149. 直线上最多的点数 Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Example 1:
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * ^ | |        o |     o |  o   +-------------> 0  1  2  3 4
 * 
 * Example 2:
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 
 * Output: 4
 * 
 * Explanation: ^ | | o |     o   o |      o |  o   o +-------------------> 0  1  2  3  4  5  6 NOTE: input types have
 * been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * 
 * @author wang
 * @date 2019/08/05
 */
public class MaxPointsOnALineSolution {

    public static void main(String[] args) {

        System.out.println(
            new MaxPointsOnALineSolution().maxPoints(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    /**
     * 使用斜率统计一条直线上的点的个数
     * 
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {

        int len = points.length;
        if (len <= 1) {
            return len;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            Map<String, Integer> count = new HashMap<>();
            int self = 1;
            int currMax = 0;
            for (int j = i + 1; j < len; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    self++;
                    continue;
                }
                int gcd = gcd(dy, dx);
                if (gcd != 0) {
                    dx = dx / gcd;
                    dy = dy / gcd;
                }
                String key = dy + "/" + dx;
                count.put(key, count.getOrDefault(key, 0) + 1);

                currMax = Math.max(currMax, count.get(key));
            }
            ans = Math.max(ans, currMax + self);
        }

        return ans;
    }

    private int gcd(int y, int x) {

        if (x == 0) {
            return y;
        }
        return gcd(x, y % x);
    }

}
