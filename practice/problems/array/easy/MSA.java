package easy;
/* 
 * > PROBLEM 88 (easy): Merge Sorted Array
 *   You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
 *   and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * 
 *   Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 *   The final sorted array should not be returned by the function, but instead be 
 *   stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
 *   where the first m elements denote the elements that should be merged, and the last
 *   n elements are set to 0 and should be ignored. nums2 has a length of n.
 * 
 * > SOLUTION: 
 *   We start sorting starting by the biggest elements: we have spare room at the end of nums1
 *   and nums1 have to become the full merged array. 
 *   The merged array will have size n+m. 
 *   This means that the last element of the merged array has index n+m-1 and its value 
 *   is the biggest from the max of nums1 and the max of nums2
 *   
 *   Using three pointers we merge the array. One pointer "insert" is the index to insert 
 *   the element by the new "merged order", and the other two pointers last1 and last2 points
 *   to the biggest elements of nums1 and nums2 
 * 
 *   Inserting as we go we decrement insert and either last1 or last2, based on which element 
 *   was inserted in the merged array. 
 *  
 *   When last2 reaches < 0 we stop since we merged fully the two arrays
 */
public class MSA {
    public void solution(int[] nums1, int m, int[] nums2, int n){
        int insert = m + n - 1; // index of the last "fake" element of nums1
        int last1 = m - 1; // index of the last element of nums1
        int last2 = n - 1; // index of the last element of nums2

        while(last2 >= 0)
            if(last1 >= 0 && nums1[last1] > nums2[last2])
                nums1[insert--] = nums1[last1--];
            else
                nums1[insert--] = nums2[last2--];
    }
}
