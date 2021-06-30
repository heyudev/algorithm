package com.heyudev.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 单词规律
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (strings.length != chars.length) {
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for (int i=0;i<strings.length;i++) {
            if (map.containsKey(chars[i])) {
                if (!Objects.equals(map.get(chars[i]),strings[i])) {
                    return false;
                }
            } else {
                map.put(chars[i],strings[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
