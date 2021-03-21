package com.alibaba.leetcode.easy.s2;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * 
 * 217. 存在重复元素
 * 
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the array, and it should return false if
 * every element is distinct.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1] Output: true
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4] Output: false
 * 
 * Example 3:
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 * 
 * @author wang
 * @date 2019/08/15
 */
public class ContainsDuplicateSolution {

    public static void main(String[] args) {

        System.out.println(new ContainsDuplicateSolution().containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> s = new HashSet<>();

        for (Integer num : nums) {
            if (s.contains(num)) {
                return true;
            }
            s.add(num);

        }
        return false;
    }
}
