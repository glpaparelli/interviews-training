package problems.linkedlist.easy;
import datastructures.ListNode;
/*
 * > PROBLEM 21 (easy): Merge Two Linked Lists
 *   You are given the heads of two sorted linked lists list1 and list2.
 *  
 *   Merge the two lists in a one sorted list. The list should be made by splicing
 *   together then nodes of the first two lists. 
 * 
 *   Return the head of the merged linked list.
 * 
 * > SOLUTION: 
 *   Basically is the merge function of the mergesort. 
 */
public class MTSL {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4, null);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4, null);

        ListNode merged = solution(list1, list2);
        ListNode.printList(merged);
    }

    public static ListNode solution(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1; 

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1.next = list1.next; 
            }else{
                current = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null)
            current = list1;
        if(list2 != null)
            current = list2;
        
        return dummy.next;
    }
}
