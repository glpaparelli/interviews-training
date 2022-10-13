package problems.linkedlist;
/*
 * > PROBLEM 61 (medium): Rotate List
 * //TODO
 */

import datastructure.ListNode;

public class RotateList {

    public static ListNode solution(ListNode head, int k){
        if(head == null)
            return null;
        if(k == 0 || head.next == null)
            return head;

        int size = ListNode.listSize(head);

        if(size == k || k % size == 0)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = new ListNode(-1, slow);
        ListNode preFast = new ListNode(-1, fast);

        for(int i = 0; i < k % size; i++){
            preFast = preFast.next;
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            preFast = preFast.next;
            preSlow = preSlow.next;
        }

        preFast.next = head; 
        preSlow.next = null;
        head = slow;
        
        return head;
    }

}   
