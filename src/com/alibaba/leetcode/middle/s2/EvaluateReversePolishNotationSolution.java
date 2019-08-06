package com.alibaba.leetcode.middle.s2;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * 150. 逆波兰表达式求值
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Note:
 * 
 * Division between two integers should truncate toward zero. The given RPN expression is always valid. That means the
 * expression would always evaluate to a result and there won't be any divide by zero operation.
 * 
 * Example 1:
 * 
 * Input: ["2", "1", "+", "3", "*"]
 * 
 * Output: 9
 * 
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * Example 2:
 * 
 * Input: ["4", "13", "5", "/", "+"]
 * 
 * Output: 6
 * 
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * Example 3:
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 
 * Output: 22
 * 
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17)
 * + 5 = ((10 * 0) + 17) + 5 = (0 + 17) + 5 = 17 + 5 = 22
 * 
 * 
 * @author wang
 * @date 2019/08/05
 */
public class EvaluateReversePolishNotationSolution {

    public static void main(String[] args) {

        System.out.println(new EvaluateReversePolishNotationSolution()
            .evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[] {"-78", "-33", "196", "+",
            "-19", "-", "115", "+", "-", "-99", "/", "-18", "8", "*", "-86", "-", "-", "16", "/", "26", "-14", "-", "-",
            "47", "-", "101", "-", "163", "*", "143", "-", "0", "-", "171", "+", "120", "*", "-60", "+", "156", "/",
            "173", "/", "-24", "11", "+", "21", "/", "*", "44", "*", "180", "70", "-40", "-", "*", "86", "132", "-84",
            "+", "*", "-", "38", "/", "/", "21", "28", "/", "+", "83", "/", "-31", "156", "-", "+", "28", "/", "95",
            "-", "120", "+", "8", "*", "90", "-", "-94", "*", "-73", "/", "-62", "/", "93", "*", "196", "-", "-59", "+",
            "187", "-", "143", "/", "-79", "-89", "+", "-"}));
    }

    /**
     * 使用栈存储数字，遇到运算符则弹出栈顶两个元素计算结果，并将结果压入栈顶
     * 
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int n1;
            int n2;
            switch (s) {
                case "+":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 + n1);
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 * n1);
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.pop();
    }

}
