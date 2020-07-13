package com.heyudev.algorithm.linkedlist;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author heyudev
 * @date 2020/07/14
 */
public class SwapNodesInPairs {

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

        Node head1 = swapNodeInPairs(head);
        while (head1 != null) {
            System.out.println(head1.value);
            head1 = head1.next;
        }

    }

    public static Node swapNodeInPairs(Node head) {
        Node curr = head;
        Node prev = head.next;
        while (curr != null) {
            Node temp = curr;
            if (curr.next != null) {
                curr.next.next = temp;
                curr.next = temp.next;
                curr=curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        if (prev != null) {
            return prev;
        }
        return curr;
    }


}
