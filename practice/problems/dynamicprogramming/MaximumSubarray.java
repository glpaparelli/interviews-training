package problems.dynamicprogramming;
/*
 * > PROBLEM 53 (medium): Maximum Subarray
 *   Given an array "nums", find the contiguous subarray (of size at least 1) which 
 *   has the largest sum and return its sum. 
 * 
 * > SOLUTION: 
 *   To solve the problem we use DP bottom-up approach. We create the array dp of the 
 *   same size of nums. 
 *   Each cell i of dp represent the maximum subarray that ends at the index i of nums
 *      - dp[i] = max subarray that ends with A[i]
 * 
 *   The base case is dp[0] = nums[0], the subarray that ends at index 0 is the subarray
 *   A[0] itself.
 *   
 *   - Example: consider the array nums = [-2,1,-3,4,-1,2,1,-5,4]
 *      - size = 9
 *      - max = nums[0] = -2
 *      - dp[] = new int[size]; 
 *      - dp[0] = nums[0] = -2;
 *      > for(int i = 1; i < size; i++)
 *          - i = 1:
 *              - dp[1] = nums[1] + (dp[0] > 0 ? dp[0] : 0) = 1 + 0 = 1
 *              - max = Max(-2, 1) = 1
 *          - i = 2: 
 *              - dp[2] = nums[2] + (dp[1] > 0 ? dp[1] : 0) = -3 + 1 = -2
 *              - max = Max(1, -2) = 1 // the max remains equal
 *          - i = 3:
 *              - dp[3] = nums[3] + (dp[2] > 0 ? dp[2] : 0) = 4 + 0 = 4
 *          - i = 4: 
 *              - dp[4] = nums[4] + (dp[3] > 0 ? dp[3] : 0) = -1 + 4 = 3
 *          - ...
 */
public class MaximumSubarray {
    //TODO main
    public static int solution(int[] nums){
        int size = nums.length;
        int max = nums[0];

        // dp[i] = max subarray ending with A[i]
        int[] dp = new int[size];
        dp[0] = nums[0];
        
        for(int i = 1; i < size; i++){
            // if the max subarray at the index i-1 is negative 
            // we "restart" the subarray (where the suarray starts)
            // by putting dp[i] = nums[i], which means that the max 
            // subarray that ends in nums[i] is the single element nums[i]
            // itself (and hence it starts with nums[i])
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
