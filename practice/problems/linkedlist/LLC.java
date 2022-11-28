package problems.linkedlist;
import java.util.HashSet;
import java.util.Set;
import datastructures.ListNode;
/*
 * > PROBLEM 141 (easy): Linked List Cycle
 *   Given the head of a linked list, determine if the linked list has a cycle in it. 
 *   
 *   There is a cycle in a linked list if there is some node in the list that can be 
 *   reached again by continuosly following the next pointer. 
 *   Internally, pos is used to denote the index of the node that tail's next pointer
 *   is connected to. Note that pos is not passed as a parameter. 
 * 
 *   Return true if there is a cycle in the linked list, otherwise return false. 
 *   Solve it in O(1) space. 
 * 
 * > SOLUTION: 
 *   The dumb solution is using a set to check if a node was already seen. 
 *   The smarter way is to color the nodes using Integer.MIN_VALUE, and if 
 *   a node has that value it means that it was already been seen. 
 */
public class LLC {
    public static void main(String[] args) {
        ListNode input1 = new ListNode(3);
        input1.next = new ListNode(2);
        input1.next.next = new ListNode(0);
        input1.next.next.next = new ListNode(-4, null);
        assert(mySolution(input1));

        ListNode input2 = new ListNode(1);
        input2.next = new ListNode(2, null);
        assert(mySolution(input2));

        ListNode input3 = new ListNode(1, null);
        assert(!mySolution(input3));
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
