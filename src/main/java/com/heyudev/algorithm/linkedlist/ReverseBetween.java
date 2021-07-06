package com.heyudev.algorithm.linkedlist;

/**
 * 反转链表2
 *
 * @author heyudev
 * @date 2021/07/06
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode re = reverseBetween(head, 2, 4);

        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prveHead = new ListNode(-1);
        prveHead.next = head;
        //前一个 固定
        ListNode prev = prveHead;
        ListNode curr = null;
        ListNode next = null;

        for (int i = 1; i <= left; i++) {
            prev = prev.next;
        }
        //不变 随着插入索引自动移动
        curr = prev.next;
        //次数  right - left
        for (int i = 0; i < right - left; i++) {
            //头插法 把后面的移除 插入到前面
            next = curr.next;
            //先移除
            curr.next = next.next;
            //插入到前面 prev后面
            next.next = prev.next;
            prev.next = next;
        }
        return prveHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
