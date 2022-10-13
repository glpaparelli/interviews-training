package problems.linkedlist;
/*
 * > PROBLEM 143 (medium): Reorder List
 * //TODO
 */

import datastructure.ListNode;

public class ReorderList {
    
    public static void solution(ListNode head){
        if (head == null || head.next == null)
            return;
    
        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null; 
        ListNode slow = head; 
        ListNode fast = head; 
        //ListNode head1 = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // step 2. reverse the 2nd half
        slow = reverse(slow);
        
        // step 3. merge the two halves
        merge(head, slow);
    }
  
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
  }
  
    public static void merge(ListNode head1, ListNode head2) {
        while (head1 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            
            if (next1 == null)
                break;

            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
}
