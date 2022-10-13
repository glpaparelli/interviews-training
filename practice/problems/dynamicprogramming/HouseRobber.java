package problems.dynamicprogramming;

import java.util.Arrays;

/*
 * > PROBLEM 198 (medium): House Robber
 *   You are a professional robber planning to rob houses along a street. 
 *   Each house has a certain amount of money stashed, the only constraint
 *   stopping you for robbing each of them is that adjacent houses have 
 *   security systems connected and it will automatically contact the police 
 *   if two adjacent houses were broken into on the same night. 
 * 
 *   Given an integer array nums representing the amount of money of each house, 
 *   return the maximum amount of money you can rob tonight without allerting
 *   the police.
 * 
 * > SOLUTION:
 *   - given by: https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 *   A comprehensive approach: every solution possible. This problem, like most 
 *   problems of this kind, can be solved with the following methods: 
 *      1) find recursive relation
 *      2) recursive (top-down)
 *      3) recursive + memeorization (DP top-down)
 *      4) iterative + tabulation (DP bottom-up)
 *      5) iterative + N variables (bottom-up)
 * 
 *   1) Find Recursive Relation
 *   The robber has 2 options:
 *      a) rob the current house i
 *      b) dont rob the current house i
 * 
 *   If the option a) is selected it means that the robber cant rob the house 
 *   i-1 but he can safely proceed to the one before i-1, that is i-2, and get 
 *   all the cumulative loot that follows. 
 *   
 *   If option b) is selected than the robbers gets all the possible loot from 
 *   robbing the house i-1 and all the following houses of i.
 * 
 *   So, basically is comes down to calculating what is more profitable: 
 *      - robbery of the current house + loot from the house before the previous house
 *      - loot from the previous house and any loot captured before that
 *  
 *   Mathematically: rob(i) = Math.max(rob(i-2) + currentHouseValue, rob(i-1))
 * 
 *   2) Recursive (Top-Down)
 *   It's basically the mathematically recurrent relation seen in step 1), 
 *   check the code.
 * 
 *   3) Recursive + Memorization (DP Top-Down)
 *   It is the previous method with the DP approach of memorization of already 
 *   computed result: this problem has the optimal subproblem property. 
 *   This is way better then step 2 since it run in O(n). The space is also O(n) 
 *   because of the memory occupied by the recursive calls .
 *   Check the code.
 * 
 *   4) Iterative + Tabulation (DP Bottom-Up)
 *   Check the code
 * 
 *   5) Iterative + 2 Variables (bottom-up)
 *   We notice that in the previous step we only use dp[i] and dp[i-1], so we just 
 *   go back of 2 steps. We can hold them in 2 var instead of computing a whole matrix
 */
public class HouseRobber {
    
    public static int solutionRecursive(int[] nums){
        return helperRecursive(nums, nums.length-1);
    }
    private static int helperRecursive(int[] nums, int i) {
        if(i < 0)
            return 0; 

        return Math.max(helperRecursive(nums, i-2) + nums[i], helperRecursive(nums, i-1));
    }

    public static int solutionDPTopDown(int[] nums){
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helperDPTopDown(nums, dp, nums.length - 1); 
    }
    private static int helperDPTopDown(int[] nums, int[] dp, int i) {
        if(i < 0)
            return 0; 
        
        if(dp[i] >= 0)
            return dp[i];

        dp[i] = Math.max(
            helperDPTopDown(nums, dp, i-2) + nums[i], 
            helperDPTopDown(nums, dp, i-1)
        );

        return dp[i];
    }

    public static int solutionDPBottomUp(int[] nums){
        if(nums.length == 0)
            return 0; 

        int dp[] = new int[nums.length+1];
        
        dp[0] = 0; 
        dp[1] = nums[0];

        for(int i = 1; i < nums.length; i++)
            /*
                > mind that every result is shifted due dp[0] = 0, this means 
                  that max amount of money solen when we are deciding if robbing the 
                  house i = i.e 2 is stored in i+1 = 3.
                
                as said in the the SOLUTION section here we se again the 
                two possible choices: when we are at the house i we can choose 
                to either rob it or not. 
                The max gained value will be the max between 
                    - option a) rob the house i (nums[i]) + the loot from robbing 
                      the houses before the previous house 
                    - option b) don't rob the house
            */
            dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
        
        return dp[nums.length];
    }

    public static int solution2Vars(int[] nums){
        if (nums.length == 0) 
            return 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


}
