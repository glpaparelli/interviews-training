package algorithms;
/*
 * > PROBLEM 704 (easy): Binary Search
 *   Given an array of integer "nums" which is sorted in ascending order, and
 *   an integer "target", write a function to search "target" in nums. If 
 *   target exists, then return its index. Otherwise return -1. 
 * 
 *   You must write an algorithm with O(log n) runtime complexity
 * 
 * > SOLUTION
 *   Classic binary search algorithm: since the array is sorted go the half of 
 *   the array, if the element in the middle is the target then you found it, 
 *   otherwise if the middle element is bigger than target then the target 
 *   will be in the left half, otherwise in the right half. 
 *   Keep the process until the target is found.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] input1 = {-1,0,3,5,9,12}; 
        int target1 = 9; 
        assert(itSolution(input1, target1) == 4);

        int[] input2 = {-1,0,3,5,9,12};
        int target2 = 2;
        assert(recSolution(input2, target2, 0, input2.length-1) == -1);
    }

    public static int itSolution(int[] nums, int target){
        int start = 0; 
        int end = nums.length -1; 
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target)
                end = mid - 1;

            if(nums[mid] < target)
                start = mid + 1;
        }

        return -1;
    }

    public static int recSolution(int[] nums, int target, int start, int end){
        if(start >= end){
            if(nums[start] == target)
                return start;
            return -1; 
        }

        int mid = (start + end) / 2;

        if(nums[mid] == target)
            return mid; 

        if(nums[mid] > target)
            return recSolution(nums, target, start, mid-1);

        if(nums[mid] < target)
            return recSolution(nums, target, mid+1, end);

        return -1; // never executed
    }
}
