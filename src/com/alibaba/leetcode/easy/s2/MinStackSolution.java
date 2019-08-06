package com.alibaba.leetcode.easy.s2;

import java.util.Stack;

/**
 * 155. Min Stack
 * 
 * 155. 最小栈
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * top() -- Get the top element.
 * 
 * getMin() -- Retrieve the minimum element in the stack.  
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * 
 * minStack.push(-2);
 * 
 * minStack.push(0);
 * 
 * minStack.push(-3);
 * 
 * minStack.getMin(); --> Returns -3.
 * 
 * minStack.pop();
 * 
 * minStack.top(); --> Returns 0.
 * 
 * minStack.getMin(); --> Returns -2.
 * 
 * 
 * @author wang
 * @date 2019/08/06
 */
public class MinStackSolution {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

class MinStack {

    Stack<Integer> stack;

    Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        if (min == null) {
            min = x;
        } else {
            min = Math.min(min, x);
        }
    }

    public void pop() {

        if (stack.isEmpty()) {
            return;
        }

        int pop = stack.pop();
        if (pop == min) {
            min = getNewMin();
        }
    }

    private Integer getNewMin() {

        if (stack.isEmpty()) {
            return null;
        }
        Integer n = stack.peek();
        for (Integer num : stack) {
            n = Math.min(n, num);
        }

        return n;
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        if (min == null) {
            return 0;
        }

        return min;
    }
}
