package com.alibaba.leetcode.easy.s2;

/**
 * 
 * 157.Read N Characters Given Read4
 * 
 * 157.用Read4来读取N个字符
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters
 * left in the file. By using the read4 API, implement the function int read(char *buf, int n) that reads n characters
 * from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @author wang
 * @date 2019/08/07
 */
public class ReadNCharactersGivenRead4Solution {

    public int read(char[] buf, int n) {

        int total = 0;

        for (int i = 0; i < n; i++) {
            char[] tmp = new char[4];
            int len = read4(tmp);

            System.arraycopy(tmp, 0, buf, i, Math.min(n - i, len));

            if (len < 4) {
                return Math.min(i + len, n);
            }
        }

        return total;
    }

    int read4(char[] chs) {

        return 4;
    }
}
