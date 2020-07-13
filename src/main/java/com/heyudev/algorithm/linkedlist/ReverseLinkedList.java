package com.heyudev.algorithm.linkedlist;

/**
 * 反转链表
 * 1、
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 2、
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author heyudev
 * @date 2020/07/13
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node("h");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        head.next = A;
        A.next = B;
        B.next = C;
        C.next = D;

        Node head1 = reverse1(head);

        while (head1 != null) {
            System.out.println(head1.value);
            head1 = head1.next;
        }

    }

    /**
     * 反转链表
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * <p>
     * 两个指针 curr,prv
     *
     * @param head
     */
    public static Node reverse1(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            //需要一个临时变量
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 反转链表 II
     * <p>
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static Node reverse2(Node head, int m, int n) {
        return null;
    }

}
