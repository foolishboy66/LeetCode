package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * 
 * @author wang
 * @date 2019/07/04
 */
public class GenerateParenthesesSolution {

    public static void main(String[] args) {

        System.out.println(new GenerateParenthesesSolution().generateParenthesis(3));
    }

    /**
     * 回溯法：基于上一个一定是正确的，如果"("数量小于最大上限，则放一个"("；如果")"数量小于"("，则放一个")"
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    private void backtrack(List<String> output, String str, int open, int close, int max) {

        if (str.length() == 2 * max) {
            output.add(str);
            return;
        }
        if (open < max) {
            backtrack(output, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(output, str + ")", open, close + 1, max);
        }

    }
}
