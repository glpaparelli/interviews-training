package problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
 * > PROBLEM 300 (medium): Longest Increasing Subsequence
 */
public class LIS {
    public static int solution(int[] nums){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        // dp[i] = longest increasing subsequence at index i
        int[] dp = new int[size];

        // base case: the longest increasing subsequence at the first 
        // index is the element itself, hence the length is 1
        dp[0] = 1;

        // dp case, similar to maximum subarray
        for(int i = 1; i < size; i++){
            if(set.contains(nums[i])){
                dp[i] = 1;
                continue; 
            }else
                set.add(nums[i]);

            if(nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
            else
                dp[i] = dp[i-1];
            
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
