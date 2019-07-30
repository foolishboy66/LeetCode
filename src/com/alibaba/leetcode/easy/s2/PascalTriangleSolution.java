package com.alibaba.leetcode.easy.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * 
 * 118. 杨辉三角
 * 
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 
 * Example:
 * 
 * Input: 5 Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * 
 * @author wang
 * @date 2019/07/29
 */
public class PascalTriangleSolution {

    public static void main(String[] args) {

        System.out.println(new PascalTriangleSolution().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>(numRows);
        if (numRows == 0) {
            return ans;
        }
        ans.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = ans.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(pre.get(j - 1) + pre.get(j));
            }

            curr.add(1);
            ans.add(curr);
        }

        return ans;
    }
}
