package easy;
/*
 * > PROBLEM 35 (easy): Search Insert Position
 *   Given a sorted array of distinct integers and a target value, return the 
 *   index if the target is found. 
 *   If not, return the index where it would be if it were inserted in order.
 * 
 *   You must write an algorithm with O(log n) runtime complexity.
 * 
 * > SOLUTION: 
 *   slightly changed iterative binary search, read the code
 */
public class SIP {
    public static int solution(int[] nums, int target){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) 
                return mid;
            else if(nums[mid] > target) 
                high = mid-1;
            else 
                low = mid+1;
        }

        // instead of -1 (as bs) we return low, which is the only possible
        // position for the target, since high and low at this point have already
        // "crossed" it cant be high, and it is surely not mid
        return low; 
    }
}
