package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135"
 * 
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 * @author wang
 * @date 2019/07/24
 */
public class RestoreIPAddressesSolution {

    public static void main(String[] args) {

        System.out.println(new RestoreIPAddressesSolution().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIPAddressesSolution().restoreIpAddresses("0000"));

        System.out.println(new RestoreIPAddressesSolution().restoreIpAddresses2("25525511135"));
        System.out.println(new RestoreIPAddressesSolution().restoreIpAddresses2("0000"));

    }

    /**
     * 解法二：dfs
     * 
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses2(String s) {

        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, "", res);
        return res;
    }

    private void dfs(String s, int start, int num, String output, List<String> res) {

        if (num > 4) {
            return;
        }
        if (start == s.length()) {
            res.add(output.substring(0, output.length() - 1));
            return;
        }
        if (s.charAt(start) == '0') {
            dfs(s, start + 1, num + 1, output + "0" + ".", res);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {
                String temp = s.substring(start, start + i);
                if (Integer.parseInt(temp) <= 255) {
                    dfs(s, start + i, num + 1, output + temp + ".", res);
                }
            }
        }

    }

    /**
     * 暴力穷举法：将字符串化为4段遍历
     * 
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        int length = s.length() - 1;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j <= i + 3; j++) {
                for (int k = j + 1; k <= j + 3; k++) {
                    if (i < length && j < length && k < length) {
                        String s1 = s.substring(0, i + 1);
                        String s2 = s.substring(i + 1, j + 1);
                        String s3 = s.substring(j + 1, k + 1);
                        String s4 = s.substring(k + 1);
                        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean isValid(String str) {

        if (str == null || str.isEmpty() || (str.length() > 1 && str.charAt(0) == '0') || str.length() > 3
            || Integer.parseInt(str) > 255) {
            return false;
        }

        return true;
    }
}
