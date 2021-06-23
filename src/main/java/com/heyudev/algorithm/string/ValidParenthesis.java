package com.heyudev.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 有效的括号
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s.length()%2!=0){
            return false;
        }
        char[] chars = s.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (char c: chars){
            if (map.containsKey(c)){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                } else {
                    if (Objects.equals(map.get(stack.peek()), c)){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
