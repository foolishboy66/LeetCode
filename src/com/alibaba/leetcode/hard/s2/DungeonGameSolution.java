package com.alibaba.leetcode.hard.s2;

/**
 * 174. Dungeon Game
 * 
 * 174. 地下城游戏
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon
 * consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room
 * and must fight his way through the dungeon to rescue the princess.
 * 
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0
 * or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each
 * step.
 * 
 *  
 * 
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal
 * path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * 
 * Note:
 * 
 * The knight's health has no upper bound.
 * 
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the
 * princess is imprisoned.
 * 
 * 
 * @author wang
 * @date 2019/08/10
 */
public class DungeonGameSolution {

    public static void main(String[] args) {

        System.out
            .println(new DungeonGameSolution().calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}

        }));
    }

    /**
     * 自底向上的动态规划：dp[i][j]表示到(i,j)最少需要的血量
     * 
     * 动态方程：dp[i][j] = max(0, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
     * 
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = dungeon[rows - 1][cols - 1] > 0 ? 0 : -dungeon[rows - 1][cols - 1];

        // 最后一行
        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(0, dp[rows - 1][j + 1] - dungeon[rows - 1][j]);
        }
        // 最后一列
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(0, dp[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0] + 1;
    }
}
