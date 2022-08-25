package problems.searching;
/*
 * > PROBLEM 33 (medium): Search in Rotated Sorted Array
 *  //TODO
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