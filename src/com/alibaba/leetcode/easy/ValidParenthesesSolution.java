package com.alibaba.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order. Note
 * that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true
 * 
 * Example 2:
 * 
 * Input: "()[]{}" Output: true
 * 
 * Example 3:
 * 
 * Input: "(]" Output: false
 * 
 * Example 4:
 * 
 * Input: "([)]" Output: false
 * 
 * Example 5:
 * 
 * Input: "{[]}" Output: true
 * 
 * 
 * @author wang
 * @date 2019/07/03
 */
public class ValidParenthesesSolution {

    public static void main(String[] args) {

        System.out.println(new ValidParenthesesSolution().isValid("()"));
        System.out.println(new ValidParenthesesSolution().isValid("()[]{}"));
        System.out.println(new ValidParenthesesSolution().isValid("(]"));
        System.out.println(new ValidParenthesesSolution().isValid("([)]"));
        System.out.println(new ValidParenthesesSolution().isValid("{[]}"));
    }

    /**
     * 使用入栈和出栈的方式
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if (s == null || s.isEmpty() || s.trim() == "") {
            return true;
        }

        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                char tmp = stack.isEmpty() ? '@' : stack.pop();
                if (dict.get(c) != tmp) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
