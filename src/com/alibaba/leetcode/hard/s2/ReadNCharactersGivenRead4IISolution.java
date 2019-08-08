package com.alibaba.leetcode.hard.s2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 158.Read N Characters Given Read4 II - Call multiple times
 * 
 * 158.用 Read4 读取 N 个字符 II
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters
 * left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 * 
 * @author wang
 * @date 2019/08/07
 */
public class ReadNCharactersGivenRead4IISolution {

    private Queue<Character> cache = new LinkedList<>();

    /**
     * 使用队列缓存上次没有读完的字符
     * 
     * @param buf
     * @param n
     * @return
     */
    public int read(char[] buf, int n) {

        int i = 0;
        while (i < n && !cache.isEmpty()) {
            char c = cache.poll();
            buf[i++] = c;
        }

        for (; i < n; i++) {
            char[] tmp = new char[4];
            int len = read4(tmp);

            if (len > n - i) {
                // buf满了
                System.arraycopy(tmp, 0, buf, i, n - i);
                for (int j = n - i; j < len; j++) {
                    cache.add(tmp[j]);
                }
            } else {
                System.arraycopy(tmp, 0, buf, i, len);
            }

            if (len < 4) {
                return Math.min(i + len, n);
            }
        }

        return n;
    }

    int read4(char[] chs) {

        return 4;
    }
}
