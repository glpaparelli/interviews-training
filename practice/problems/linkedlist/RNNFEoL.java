package problems.linkedlist;
/*
 * > PROBLEM 19 (medium): Remove N-th Node From End of List
 * //TODO
 * in one pass
 */

import datastructure.ListNode;

public class RNNFEoL {


    public ListNode solution(ListNode head, int n){
        ListNode start = new ListNode(-1, head);
        ListNode slow = start;
        ListNode fast = start;

        for(int i = 0; i < n+1; i++)   
            fast = fast.next;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //TODO attenzione ai giochini con i puntatori nel caso [1,2], 2
        slow.next = slow.next.next;
        return start.next;
    }
}
