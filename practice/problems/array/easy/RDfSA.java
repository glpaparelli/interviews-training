package easy;
/*
 * > PROBLEM 26 (easy): Remove Duplicates from Sorted Array
 *   Given an integer array nums sorted in non-decreasing order, 
 *   remove the duplicates in-place such that each unique element appears only once. 
 *   The relative order of the elements should be kept the same.
 * 
 *   Since it is impossible to change the length of the array in some languages, 
 *   you must instead have the result be placed in the first part of the array nums. 
 *   More formally, if there are k elements after removing the duplicates, then 
 *   the first k elements of nums should hold the final result. 
 *   It does not matter what you leave beyond the first k elements.
 * 
 *   Return k after placing the final result in the first k slots of nums.
 *   
 *   Do not allocate extra space for another array. 
 *   You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * > SOLUTION: 
 *   read the code
 */
public class RDfSA {
    public static int solution(int[] nums){
        // this method works only because nums is sorted!

        // the first element of the array (at index 0) is surely at 
        // its right place since, if any, the repeated elements will 
        // be later on (it is the first element, duh)
        int insertIndex = 1; 
        for(int i = 1; i < nums.length; i++)
            // we store the unique element at position insertIndex 
            // and we increment insertIndex by 1
            if(nums[i-1] != nums[i]){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        
        return insertIndex;
    }
}
