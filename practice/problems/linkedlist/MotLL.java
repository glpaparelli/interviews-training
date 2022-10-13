package problems.linkedlist;
/*
//TODO
 * > PROBLEM 876 (easy): Middle of the Linked List
 */

import datastructure.ListNode;

public class MotLL {
    public ListNode solution(ListNode head){
        if (head == null)
            return null; 
        if(head.next == null)
            return head;
        
        int size = 0; 
        ListNode tmp = head;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
        
        ListNode slow = head;
        ListNode fast = head.next; 

        while (fast != null && fast.next != null){ 
            slow = slow.next; 
            fast = fast.next.next; 
        }
                
        if(size % 2 == 0)
            return slow.next;
        else 
            return slow;

        }
}
