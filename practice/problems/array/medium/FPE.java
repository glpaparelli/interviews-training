package medium;
/*
 * > PROBLEM 162 (medium): Find Peak Element
 *   A peak element is an element that is strictly greater than its neighbors.
 *   
 *   Given a 0-indexed integer array nums, find a peak element, and return its index. 
 *   If the array contains multiple peaks, return the index to any of the peaks.
 * 
 *   You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always 
 *   considered to be strictly greater than a neighbor that is outside the array.
 * 
 *   You must write an algorithm that runs in O(log n) time.
 * 
 * > SOLUTION: 
 *   tricky solution, TO DO comments and explaination
 */
public class FPE {
    public static void main(String[] args) {
        // System.out.println(solution(new int[]{1,2,3,1}));
        // System.out.println(solution(new int[]{1,2,1,3,5,6,4}));
        System.out.println(solution(new int[]{0,1}));
    }

    public static int solution(int[] nums){
        return helper(nums, 0, nums.length-1);
    }

    // custom BS that returns the index of the peak element
    private static int helper(int[] nums, int start, int end){
        if(start == end)
            return start; 

        int middle = (start + end) / 2; 

        if(nums[middle] > nums[middle+1])
            return helper(nums, start, middle);
        else
            return helper(nums, middle+1, end);
    }
}
