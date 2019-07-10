package com.alibaba.leetcode.hard;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * 
 * Example 1:
 * 
 * Input: "(()"
 * 
 * Output: 2
 * 
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * Example 2:
 * 
 * Input: ")()())"
 * 
 * Output: 4
 * 
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 * @author wang
 * @date 2019/07/08
 */
public class LongestValidParenthesesSolution {

    public static void main(String[] args) {

        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses("(()"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses("()"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses("("));
        
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses2("(()"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses2(")()())"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses2("()"));
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses2("("));
    }

    /**
     * 解法一：暴力穷举法，超时不能AC
     * 
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        int maxLen = 0;
        if (s == null || s.length() < 2) {
            return maxLen;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j += 2) {
                String ss = s.substring(i, j + 1);
                if (isValid(ss)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 解法二：使用栈的方式，用栈保存"("和")"的下标
     * 
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {

        int maxLen = 0;
        if (s == null || s.length() < 2) {
            return maxLen;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

}
