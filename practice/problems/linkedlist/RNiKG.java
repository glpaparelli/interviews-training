package problems.linkedlist;
import datastructure.ListNode;
/*
 * > PROBLEM 25 (hard): Reverse Nodes in k-Group
 * //TODO
 */
public class RNiKG {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.printList(head);
        solution(head, 2);
        ListNode.printList(head);
    }

    public static ListNode solution(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        //the head of the sublist we have to reverse
        ListNode nextHead = dummy;

        while(true) {
            ListNode previous = nextHead;
            ListNode current = nextHead; 
            ListNode kth = nextHead;
            nextHead = previous.next;

            for(int i = 0; i < k && kth != null; i++) 
                kth = kth.next;

            // what if there are left less than k elements?
            if(kth == null) 
                break;
                
            for(int i = 0; i < k-1; i++) {
                current = previous.next;
                previous.next = current.next;
                current.next = kth.next;
                kth.next = current;
            }
        }
        return dummy.next;
    }
}