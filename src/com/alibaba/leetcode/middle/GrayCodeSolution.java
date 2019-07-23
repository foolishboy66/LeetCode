package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A
 * gray code sequence must begin with 0.
 * 
 * Example 1:
 * 
 * Input: 2 Output: [0,1,3,2]
 * 
 * Explanation:
 * 
 * 00 - 0
 * 
 * 01 - 1
 * 
 * 11 - 3
 * 
 * 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined. For example, [0,2,3,1] is also a valid gray code
 * sequence.
 * 
 * 00 - 0
 * 
 * 10 - 2
 * 
 * 11 - 3
 * 
 * 01 - 1
 * 
 * Example 2:
 * 
 * Input: 0 Output: [0]
 * 
 * Explanation: We define the gray code sequence to begin with 0.   A gray code sequence of n has size = 2n, which for n
 * = 0 the size is 20 = 1.   Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 
 * @author wang
 * @date 2019/07/23
 */
public class GrayCodeSolution {

    public static void main(String[] args) {

        System.out.println(new GrayCodeSolution().grayCode(2));
        System.out.println(new GrayCodeSolution().grayCode(3));

        System.out.println(new GrayCodeSolution().grayCode2(2));
        System.out.println(new GrayCodeSolution().grayCode2(3));
    }

    /**
     * 解法一：动态规划的镜像法，gray(n+1)是gray(n)的数正序前添加0与倒序排前添加1的集合
     * 
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>(Arrays.asList(0));

        for (int i = 0; i < n; i++) {

            int bit = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + bit);
            }
        }
        return res;
    }

    /**
     * 解法二：利用公式——格雷数是当前位的数与前一位的数的二进制数的异或
     * 
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
