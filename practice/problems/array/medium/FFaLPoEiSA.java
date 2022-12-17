package medium;

import java.util.Arrays;

/*
 * > PROBLEM 34 (medium): Find First and Last Position of Element in Sorted Array
 *   Given an array of intergers "nums" sorted in non-decreasing order, find the 
 *   starting and ending position of a given target value. 
 * 
 *   If target is not found in the array, return [-1, -1]
 *   
 *   You must write an algorithm with O(logn) runtime complexity. 
 * 
 * > SOLUTION: 
 *   Use a custom binary search that returns the index of the target element if the 
 *   element is found and -1 otherwise. 
 * 
 *   Then starting from the index we go to its right and to its left: while the elements
 *   are equal we increment the border of the range we have to return
 */
public class FFaLPoEiSA {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{}, 6)));    
    }

    public static int[] solution(int[] nums, int target){
        int targetIndex = binarySearch(nums, target);
        if(targetIndex == -1)
            return new int[]{-1,-1};

        int[] result = new int[2];
        Arrays.fill(result, targetIndex);

        int right = targetIndex +1; 
        int left = targetIndex -1; 

        while(right < nums.length && nums[right] == target){
            result[1] = right; 
            right++;
        }
        while(left >= 0 && nums[left] == target){
            result[0] = left; 
            left--;
        }

        return result;
    }

    // returns the index of target in nums or -1
    private static int binarySearch(int[] nums, int target){
        int start =  0; 
        int end = nums.length-1;

        while(start <= end){
            int middle = (start + end)/2;

            if(nums[middle] == target)
                return middle; 

            if(nums[middle] > target)
                end = middle -1;
            else
                start = middle +1;
        }

        return -1; 
    }
}
