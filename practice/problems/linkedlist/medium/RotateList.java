package problems.linkedlist.medium;
import datastructures.ListNode;
/*
 * > PROBLEM 61 (medium): Rotate List
 *   Given the head of a linked list list, rotate the list to the right by k places.
 * 
 * > SOLUTION: 
 *   Use 4 pointers to rotate the list once reached the k-th element
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode input1 = new ListNode(1); 
        input1.next = new ListNode(2); 
        input1.next.next = new ListNode(3);
        input1.next.next.next = new ListNode(4);
        input1.next.next.next.next = new ListNode(5, null);

        ListNode.printList(input1);
        ListNode output1 = solution(input1, 2);
        ListNode.printList(output1);
    }

    public static ListNode solution(ListNode head, int k){
        if(head == null)
            return null;
        if(k == 0 || head.next == null)
            return head;

        int size = ListNode.listSize(head);

        // if list size is multiple of k the rotation has no effect
        if(size == k || k % size == 0)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = new ListNode(-1, slow);
        ListNode preFast = new ListNode(-1, fast);

        for(int i = 0; i < k % size; i++){
            preFast = preFast.next;
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            preFast = preFast.next;
            preSlow = preSlow.next;
        }

        preFast.next = head; 
        preSlow.next = null;
        head = slow;
        
        return head;
    }
}   
