package com.alibaba.leetcode.middle.s2;

/**
 * 134. Gas Station
 * 
 * 134. 加油站
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 * 
 * Note:
 * 
 * If there exists a solution, it is guaranteed to be unique. Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * gas = [1,2,3,4,5] cost = [3,4,5,1,2]
 * 
 * Output: 3
 * 
 * Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4 Travel to station 4.
 * Your tank = 4 - 1 + 5 = 8 Travel to station 0. Your tank = 8 - 2 + 1 = 7 Travel to station 1. Your tank = 7 - 3 + 2 =
 * 6 Travel to station 2. Your tank = 6 - 4 + 3 = 5 Travel to station 3. The cost is 5. Your gas is just enough to
 * travel back to station 3. Therefore, return 3 as the starting index.
 * 
 * Example 2:
 * 
 * Input: gas = [2,3,4] cost = [3,4,3]
 * 
 * Output: -1
 * 
 * Explanation:
 * 
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station. Let's start at station 2
 * and fill up with 4 unit of gas. Your tank = 0 + 4 = 4 Travel to station 0. Your tank = 4 - 3 + 2 = 3 Travel to
 * station 1. Your tank = 3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4 unit of gas but you only
 * have 3. Therefore, you can't travel around the circuit once no matter where you start.
 * 
 * 
 * @author wang
 * @date 2019/08/02
 */
public class GasStationSolution {

    public static void main(String[] args) {

        System.out
            .println(new GasStationSolution().canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));

        System.out.println(new GasStationSolution().canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));

        System.out.println(
            new GasStationSolution().canCompleteCircuit2(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));

        System.out.println(new GasStationSolution().canCompleteCircuit2(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
    }

    /**
     * 使用变量记录当前剩余油量、总剩余油量以及开始的序号，当前剩余油量小于0时，说明不能从start开始，需要从当前遍历的下一个加油站开始
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int totalLeft = 0;
        int currLeft = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalLeft += gas[i] - cost[i];
            currLeft += gas[i] - cost[i];
            if (currLeft < 0) {
                currLeft = 0;
                start = i + 1;
            }
        }

        return totalLeft < 0 ? -1 : start;
    }

    /**
     * 解法一：暴力穷举法
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = cost.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < len; i++) {
            if (canComplete(left, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean canComplete(int[] left, int start) {

        if (left[start] < 0) {
            return false;
        }

        int leftGas = 0;
        for (int i = start; i < left.length; i++) {
            leftGas += left[i];
            if (leftGas < 0) {
                return false;
            }
        }
        for (int i = 0; i < start; i++) {
            leftGas += left[i];
            if (leftGas < 0) {
                return false;
            }
        }

        return true;
    }
}
