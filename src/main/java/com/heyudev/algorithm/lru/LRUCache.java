package com.heyudev.algorithm.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author heyudev
 * @date 2021/06/23
 */
public class LRUCache {


    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(){
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node tail;
    private Node head;


    public LRUCache(int capacity) {
        size=0;
        this.capacity = capacity;
        tail  = new Node();
        head = new Node();
        head.next = tail;
        tail.pre =head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key,value);
            addToHead(newNode);
            cache.put(key,newNode);
            size++;
        } else {
            node.value = value;
            moveToHead(node);
        }
        if (size > capacity) {
            Node tailPre = removeTail();
            cache.remove(tailPre.key);
            size--;
        }
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public Node removeTail(){
        Node node = tail.pre;
        removeNode(node);
        return node;
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
