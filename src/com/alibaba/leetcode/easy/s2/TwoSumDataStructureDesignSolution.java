package com.alibaba.leetcode.easy.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * 170.Two Sum III - Data structure design
 * 
 * 170.两数之和 III - 数据结构设计
 * 
 * Design and implement a TwoSum class. It should support the following operations:add and find.
 * 
 * add - Add the number to an internal data structure.
 * 
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * 
 * For example,
 * 
 * add(1); add(3); add(5);
 * 
 * find(4) -> true
 * 
 * find(7) -> false
 * 
 * @author wang
 * @date 2019/08/09
 */
public class TwoSumDataStructureDesignSolution {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(2));
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
    }

}

class TwoSum {

    private Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {

        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {

        for (Integer n1 : map.keySet()) {
            int target = value - n1;

            return (target == n1 && map.get(n1) > 1) || (target != n1 && map.containsKey(target));
        }

        return false;
    }
}
