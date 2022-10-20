package problems.dynamicprogramming;
import java.util.Arrays;
/*
 * > PROBLEM 300 (medium): Longest Increasing Subsequence
 *   Given an integer array nums, return the length of the longest strictly 
 *   increasing subsequence. 
 * 
 *   A subsequence is a sequence that can be derived from an array by deleting 
 *   some or no elements without changing the order of the remaining elements. 
 *   
 *   For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
 * 
 * > SOLUTION: 
 *   bottom-up dynamic programming, read the code
 */
public class LIS {
    public static void main(String[] args) {
        int[] input1 = {10,9,2,5,3,7,101,18};
        assert(solution(input1) == 4);

        int[] input2 = {0,1,0,3,2,3};
        assert(solution(input2) == 4);

        int[] input3 = {7,7,7,7,7,7,7};
        assert(solution(input3) == 1);
    }

    public static int solution(int[] nums){
        if(nums.length == 1)
            return 1;

        // dp[i] = length of the increasing sequence that ends in i
        int[] dp = new int[nums.length];
        // base case = every element is a sequence of length 1 of increasing values
        Arrays.fill(dp, 1);

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= i-1; j++)
                // if the current number is bigger than a previous number than
                // we update the dp with the max between the lenght of the 
                // increasing sequence that ends at i and the length of the 
                // increasing sequence that ends at j plus 1 (given by the current num)
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
