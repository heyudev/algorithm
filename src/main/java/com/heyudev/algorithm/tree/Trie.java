package com.heyudev.algorithm.tree;

/**
 * 前缀树
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            //避免覆盖isEnd的值
            Trie node = curr.children[index];
            if (node == null) {
                node = new Trie();
                curr.children[index] = node;
            }
            curr = node;
        }
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Trie curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            Trie node = curr.children[index];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return curr.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            Trie node = curr.children[index];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // 返回 True
//        trie.search("app");     // 返回 False
//        trie.startsWith("app"); // 返回 True
//        trie.insert("app");
//        trie.search("app");     // 返回 True
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.insert("apps");
        trie.search("app");
        trie.startsWith("app");

    }

}
