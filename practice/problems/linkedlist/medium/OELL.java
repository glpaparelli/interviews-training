package problems.linkedlist.medium;
import datastructures.ListNode;
/*
 * > PROBLEM 328 (medium): Odd Even Linked List
 *   Given the head of a singly linked list, group all the nodes with odd 
 *   indices toghether followed by the nodes with even indices, and return the 
 *   reordered list. 
 * 
 *   The first node is considered odd, and the second node is even, and so on. 
 * 
 *   Note that the relative order inside both the even and odd groups should remain
 *   as it was in the input. 
 *   You must solve the problem in O(1) extra space complexity and O(n) time complexity
 * 
 * > SOLUTION: 
 *   First we need to know how long is the list size and its tail, then we play 
 *   with the index to flip the elements as needed.
 */
public class OELL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.printList(head);
        solution(head);
        ListNode.printList(head);
    }

    public static ListNode solution(ListNode head){
        if(head == null)
            return null;
        if(head.next == null || head.next.next == null)
            return head;
        
        ListNode tail = head; 
        int size = 1;
        while(tail.next != null){
            size++;
            tail = tail.next; 
        }

        ListNode previous = head;
        ListNode current = head.next; 

        for(int i = 1; i <= size; i++){
            // if the index is odd then we leave it there
            if(i % 2 != 0)
                continue;

            previous.next = current.next; 
            current.next = null;
            tail.next = current; 
            tail = current;
            previous = previous.next; 
            current = previous.next; 
        }
        
        return head;
    }
}   
