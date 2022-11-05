package problems.linkedlist;
import datastructures.ListNode;
/*
 * > PROBLEM 24 (medium): Swap Nodes in Pairs
 *   Given a linked list, swap every two adjacent nodes and return its head. 
 *   You must solve the problem without modifying the values in the list's nodes
 *   (i.e., only nodes themselves may be changed)
 * 
 * > SOLUTOIN: 
 *   Indices play
 */
public class SniP {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4, null);
        
        ListNode.printList(head);
        head = solution(head);
        ListNode.printList(head);
    }

    public static ListNode solution(ListNode head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        if(head.next.next == null){
            ListNode tmp = head.next;
            tmp.next = head;
            head.next = null;
            head = tmp; 
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode previous = dummy;
        ListNode current = head;
        ListNode next = head.next;

        while(current != null && next != null){
            swapPair(previous, current, next);
            next = current;
            current = previous.next;
    
            try {
                previous = previous.next.next;
                current = next.next;
                next = current.next;
            } catch (NullPointerException e) {
                break;
            }
        }

        return dummy.next;
    }

    private static void swapPair(ListNode previous, ListNode current, ListNode next) {
        previous.next = next;
        current.next = next.next;
        next.next = current;
    }
}
