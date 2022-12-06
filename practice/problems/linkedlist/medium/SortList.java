package problems.linkedlist.medium;
import datastructures.ListNode;
/*
 * > PROBLEM 148 (medium): Sort List
 *   Given the head of a linked list, return the list after 
 *   sorting in ascending order.
 *   - Solve it in O(nlogn) time and O(1) space.
 * 
 * > SOLUTION: 
 *   To respect the efficiency contraint we have to use another 
 *   version of mergesort, the bottom-up merge sort. 
 * 
 *   The top down approach for merge sort uses O(logn) extra space
 *   due to recursive call stack. 
 *   Let's see how we can implemenet merge sort using constant extra
 *   space, using the bottom up approach. 
 * 
 *   We Start by splitting the problem into the smallest subproblem
 *   and iteratively merge the result to solve the original problem: 
 *   - first the list is split into sublists of size 1 and merged 
 *     iteratively in sorted order. The merged list is solved 
 *     similarly
 *   - the process continues until we sort the entire list
 * 
 *   Let's see the algorithm: 
 *   - Assume n is the number of nodes in the LL
 *      - split the lists into sublists of size 1. Each adjacent 
 *        pair of size 1 is merged in sorted order. After the first
 *        iteration we get the sorted lists of size 2. A similar process
 *        is repeated for sublists of size 2. In this way, we iteratively 
 *        split the list into sublists of size 1,2,4,8,... and so on until
 *        we reach n
 *      - to split the list into two sublists of given size beginning from
 *        start, we use two pointers, mid and end that referecnes to the 
 *        start and end of the second list respectively. The split process 
 *        finds the middle of linked lists for the given size. 
 *      - merge the lists in sorted order
 *      - as we iteratively split the list and merge we have to keep track of
 *        the previous merged list using pointer tail and next sublist to be 
 *        sorted using pointer nextSubList
 */
public class SortList {
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();
    
    public ListNode solution(ListNode head){
        if (head == null || head.next == null)
            return head;

        int n = ListNode.listSize(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();

        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;

            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }

                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }

            start = dummyHead.next;
        }

        return dummyHead.next;
    }

    public ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;

        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) 
                end = (end.next.next != null) ? end.next.next : end.next;
            
            if (midPrev.next != null) 
                midPrev = midPrev.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;

        // return the start of second linked list
        return mid;
    }

    void merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }

        newTail.next = (list1 != null) ? list1 : list2;

        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) 
            newTail = newTail.next;
        
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }
}
