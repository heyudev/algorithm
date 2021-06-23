package com.heyudev.algorithm.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author supeng
 * @date 2021/06/23
 */
public class LRUCache {
    private Deque<Integer> deque = new LinkedList<>();
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map == null) {
            map = new HashMap<>();
        }
        deque.addFirst(key);
        map.put(key, value);
        if (deque.size() > capacity) {
            int rmkey = deque.pollLast();
            map.remove(rmkey);
        }
    }

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4

        LRUCache lRUCache2 = new LRUCache(2);
        lRUCache2.get(2);  // -1
        lRUCache2.put(2, 6); // 缓存是 {2==6}
        lRUCache2.get(1);    // 返回 -1
        lRUCache2.put(1, 5); // 该操作会使得关键字 2 作废，缓存是 {1=5, 2=6}
        lRUCache2.put(1, 2); // 该操作会使得关键字 1 作废，缓存是 {1=2, 2=6}
        lRUCache2.get(1);    // 返回 2
        lRUCache2.get(2);    // 返回 6


    }
}
