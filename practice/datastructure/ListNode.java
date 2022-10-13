package datastructure;
/*
 * simple definition of a singly linked list, also leetcode fluff
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){

    }
    public ListNode(int val){ 
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val; 
        this.next = next;
    }

    public static void printList(ListNode head) {
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(" " + tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static int listSize(ListNode head) {
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size; 
    }
}
