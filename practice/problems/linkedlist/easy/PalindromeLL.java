package problems.linkedlist.easy;
import datastructures.ListNode;
/*
 * > PROBLEM 234 (easy): Palindrome Linked List
 *   Given the head of a singly linked list, return true if it is a palindrome
 *   or false otherwise. 
 *   The solution must be in O(n) time and O(1) space
 * 
 * > SOLUTION: 
 *   Reach the middle of the list. Reverse the list from the middle to the end. 
 *   Starting from the head and from the middle, if every elements are equal than 
 *   the list was palindrome, false otherwise. 
 */
public class PalindromeLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(solution(head));
    }

    public static boolean solution(ListNode head){
        if(head == null)
            return false;
        if(head.next == null)
            return true;

        int size = ListNode.listSize(head);
        
        ListNode half = head;
        int middle = size / 2;
        if(size % 2 != 0)
            middle++;
        
        while(middle != 0){
            middle--;
            half = half.next;
        }
    
        half = reverseLL(half);

        while(half != null){
            if(head.val != half.val)
                return false;

            half = half.next;
            head = head.next;
        }

        return true;
    }

    public static ListNode reverseLL(ListNode head){
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
}
