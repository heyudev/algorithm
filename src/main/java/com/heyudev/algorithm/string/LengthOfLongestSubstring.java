package com.heyudev.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串  滑动窗口
 * @author heyudev
 * @date 2021/07/06
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring("abcabcbb");
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
