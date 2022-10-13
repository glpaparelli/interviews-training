package problems.linkedlist;
import datastructure.ListNode;
/*
 * > PROBLEM 2 (medium): Add Two Numbers
 * 
 */
public class Add2Nums {
    public static ListNode solution(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;

        while(list1 != null || list2 != null || carry != 0){
            int x = list1 != null ? list1.val : 0; 
            int y = list2 != null ? list2.val : 0; 

            int sum = x + y + carry;
            carry = sum / 10; 
            current.next = new ListNode(sum % 10);
            current = current.next;

            if(list1 != null)
                list1 = list1.next;
            if(list2 != null)
                list2 = list2.next;
        }

        return dummy.next;
    }
}
