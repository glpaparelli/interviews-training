package problems.binarysearch;
/*
 * > PROBLEM 33 (medium): Search in Rotated Sorted Array
 *  There is an integer array nums sorted in ascending order (with distinct values).
 *  
 *  Prior to being passed to your function, nums is possibly rotated at an 
 *  unknown pivot index k (1 <= k < nums.length) such that the resulting array is 
 *  [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
 *  
 *  For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become 
 *  [4,5,6,7,0,1,2].
 * 
 *  Given the array nums after the possible rotation and an integer target, 
 *  return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 *  You must write an algorithm with O(log n) runtime complexity.
 * 
 * > SOLUTION: 
 *   Adaptation of binary search taking into account the rotation when deciding 
 *   which half explore. 
 */
public class SiRSA {
    public static int solution(int[] nums, int target){
        return backtrack(nums, target, 0, nums.length-1);
    }

    public static int backtrack(int[] nums, int target, int start, int end){
        if(start >= end){
            if(nums[start] == target)
                return start;
            
            return -1; 
        }

        int mid = (start + end) / 2;
        int result = 0;        

        if(nums[mid] == target)
            return mid; 

        // if the middle element is bigger than we explore the left half
        // because of the rotation
        if(nums[mid] > target){
            result = backtrack(nums, target, start, mid-1);

            if(result != -1)
                return result; 

            return backtrack(nums, target, mid+1, end);
        }

        if(nums[mid] < target){
            result = backtrack(nums, target, mid+1, end);

            if(result != -1)
                return result; 

            return backtrack(nums, target, start, mid-1);
        }

        return -1;
    }
}