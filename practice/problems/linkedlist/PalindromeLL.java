package problems.linkedlist;

import datastructure.ListNode;

/*
 * > PROBLEM 234 (easy): Palindrome Linked List
 * //TODO 
 * must do in O(n) time and O(1) space
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
