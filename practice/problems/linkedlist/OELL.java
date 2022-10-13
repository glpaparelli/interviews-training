package problems.linkedlist;
import datastructure.ListNode;
/*
    //TODO
 * > PROBLEM 328 (medium): Odd Even Linked List
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
