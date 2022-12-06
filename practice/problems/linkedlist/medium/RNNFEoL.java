package problems.linkedlist.medium;
import datastructures.ListNode;
/*
 * > PROBLEM 19 (medium): Remove N-th Node From End of List
 *   Given the head of a linked list, remove the n-th node from the end of the 
 *   list and return its head. 
 *   It must be done in one pass. 
 * 
 * > SOLUTION: 
 *   Simply reach the n-th-1 node with the slow/fast trick and then skip the 
 *   n-th node by changing n-th-1.next = n-th-1.next.next
 */
public class RNNFEoL {
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

    public static ListNode solution(ListNode head, int n){
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i < n+1; i++)   
            fast = fast.next;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
