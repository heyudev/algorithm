package com.heyudev.algorithm.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码
 * @author supeng
 * @date 2021/06/23
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (']' == c) {
                StringBuffer stringBuffer1 = new StringBuffer();
                while (!deque.isEmpty()) {
                    char c1 = deque.pollFirst();
                    if ('[' == c1) {
                        StringBuffer intStringBuffer = new StringBuffer();
                        while (!deque.isEmpty() && Character.isDigit(deque.getFirst())){
                            intStringBuffer.append(deque.pollFirst());
                        }
                        int count = Integer.parseInt(intStringBuffer.reverse().toString());
                        String s1 = stringBuffer1.reverse().toString();
                        for (int j = 0; j < count; j++) {
                            for (char c2 : s1.toCharArray()) {
                                deque.addFirst(c2);
                            }
                        }
                        break;
                    } else {
                        stringBuffer1.append(c1);
                    }
                }
            } else {
                deque.addFirst(c);
            }
        }
        while (!deque.isEmpty()){
            stringBuffer.append(deque.pollLast());
        }
        return stringBuffer.toString();
    }
}
