package com.alibaba.leetcode.easy.s2;

/**
 * 292. Nim Game
 * 
 * 292. Nim 游戏
 * 
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
 * win the game given the number of stones in the heap.
 * 
 * Example:
 * 
 * Input: 4
 * 
 * Output: false
 * 
 * Explanation: If there are 4 stones in the heap, then you will never win the game;   No matter 1, 2, or 3 stones you
 * remove, the last stone will always be   removed by your friend.
 * 
 * 
 * @author wang
 * @date 2019/08/16
 */
public class NimGameSolution {

    public static void main(String[] args) {

        System.out.println(new NimGameSolution().canWinNim(4));
    }

    /**
     * 只有当个数为4的倍数时才会输
     * 
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {

        return n % 4 != 0;
    }
}
