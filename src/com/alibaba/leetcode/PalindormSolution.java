package com.alibaba.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome. Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore it is not a palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 * @author wang
 * @date 2019/06/30
 */
public class PalindormSolution {

    public static void main(String[] args) {
        System.out.println(new PalindormSolution().isPalindrome(0));
        System.out.println(new PalindormSolution().isPalindrome(-10));
        System.out.println(new PalindormSolution().isPalindrome(101));
        System.out.println(new PalindormSolution().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }

        int[] arr = new int[16];
        int len = 0;
        while (x > 0) {
            arr[len++] = x % 10;
            x /= 10;
        }

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }

        return true;
    }

}
