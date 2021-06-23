package com.heyudev.algorithm;

import java.util.*;

/**
 * @author supeng
 * @date 2021/06/23
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
