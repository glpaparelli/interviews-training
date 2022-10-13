package problems.linkedlist;
/*
 * > PROBLEM 21 (easy): Merge Two Linked Lists
 */
//TODO
import datastructure.ListNode;

public class MTSL {
    public ListNode solution(ListNode list1, ListNode list2){
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
