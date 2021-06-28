package com.heyudev.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 找不同
 */
public class FindTheDifference {
    /**
     * 计数法
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a'] -= 1;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return '0';
    }

    /**
     * 异或
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
