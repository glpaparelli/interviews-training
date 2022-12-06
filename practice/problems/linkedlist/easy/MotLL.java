package problems.linkedlist.easy;
import datastructures.ListNode;
/*
 * > PROBLEM 876 (easy): Middle of the Linked List
 *   Given the head of a singly linked list, return the middle node of the
 *   linked list. 
 *   If there are two middle nodes, return the second middle node.
 * 
 * > SOLUTION: 
 *   The solution is trivial: first we compute the size of the list, then we 
 *   use two pointer, "slow" and "fast". 
 *   We make fast increments twice as slow, when fast reach the end (.next == null) 
 *   slow is at the middle. 
 *   If size is even then there are two middle and we return slow.next, otherwise we
 *   return slow.
 */
public class MotLL {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        ListNode output1 = solution(list1);
        ListNode.printList(output1);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);
        list2.next.next.next.next = new ListNode(5);
        list2.next.next.next.next.next = new ListNode(6);
        ListNode output2 = solution(list2);
        ListNode.printList(output2);
    }

    public static ListNode solution(ListNode head){
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
