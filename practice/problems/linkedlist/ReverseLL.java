package problems.linkedlist;
import datastructure.ListNode;
/*
 * > PROBLEM 206 (easy): Reverse Linked List
 *   Given the head of a singly linked list, reverse the list and return 
 *   the reversed list. 
 */
public class ReverseLL {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        list1 = itSolution(list1);
        ListNode.printList(list1);
    }

    public static ListNode itSolution(ListNode head){
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

    public static ListNode recSolution(ListNode head){
        return recursion(head, null);
    }

    private static ListNode recursion(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        
        ListNode next = head.next;
        head.next = newHead;
        return recursion(next, head);
    }
}