package problems.linkedlist;

import java.util.HashSet;
import java.util.Set;

import datastructure.ListNode;

/*
 * > PROBLEM 141 (easy): Linked List Cycle
 * //TODO
 * - solve it in O(1) space
 */

public class LLC {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(3);
        h.next.next = h;
        System.out.println(solution(h));
    }

    public static boolean dumbSolution(ListNode head){
        Set<ListNode> nodeSet = new HashSet<>();

        ListNode current = head;
        while(current != null){
            if(nodeSet.contains(current))
                return true;
            nodeSet.add(current);
            current = current.next;
        }

        return false; 
    }

    //coloring node solution
    public static boolean mySolution(ListNode head){
        while(head != null){
            if(head.val == Integer.MIN_VALUE)
                return true; 
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }

        return false;
    }

    //two pointers solution
    public static boolean solution(ListNode head){
        if (head == null || head.next == null) 
    		return false; 
  
        ListNode slow = head;
        ListNode fast = head.next; 
  
        while (fast != null && fast.next != null){ 
            if (slow == fast) 
                return true; 

            slow = slow.next; 
            fast = fast.next.next; 
        }

        return false;
    }
}
