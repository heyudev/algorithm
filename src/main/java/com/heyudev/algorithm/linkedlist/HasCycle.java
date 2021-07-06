package com.heyudev.algorithm.linkedlist;

/**
 * 探测是否有环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author heyudev
 * @date 2020/07/14
 */
public class HasCycle {
    /**
     * 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head ==null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast ==null || fast.next ==null) {
                return false;
            }
            slow =slow.next;
            fast = fast.next.next;
        }
        return true;
    }
¬

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

}
