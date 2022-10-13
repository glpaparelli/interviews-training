package problems.linkedlist;
/*
//TODO
 * > PROBLEM 206 (easy): Reverse Linked List
 */

import datastructure.ListNode;

public class ReverseLL {
    
    public ListNode solution(ListNode head){
        ListNode previous = null;
        ListNode current = head; 
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public ListNode recSolution(ListNode head){
        return recursion(head, null);
    }

    private ListNode recursion(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        
        ListNode next = head.next;
        head.next = newHead;
        return recursion(next, head);
    }


}
