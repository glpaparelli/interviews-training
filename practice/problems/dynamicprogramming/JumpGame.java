package problems.dynamicprogramming;
/*
 * > PROBLEM 55 (medium): Jump Game
 *   You are given an integer array "nums". You are initially positioned
 *   at the array's first index, and each element in the array represents your 
 *   maximum jump length at that position. 
 * 
 *   Return true if you can reach the last index, or false otherwise.
 * 
 * > SOLUTION: 
 *   Classic bottom-up DP, check the code.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] input1 = {2,3,1,1,4};
        assert(solution(input1));

        int[] input2 = {3,2,1,0,4};
        assert(!solution(input2));
    }

    public static boolean solution(int[] nums){
        if(nums.length == 1)
            return true; 

        // dp[i] = true if i is reachable from zero
        boolean[] dp = new boolean[nums.length];
        
        // base case: 0 can be obviously reached from 0
        dp[0] = true;

        for(int i = 1; i < nums.length; i++)
            for(int j = i-1; j >= 0; j--)
                /*
                    if j is reachable from zero and we can reach i 
                    from j then we can reach i from zero!
                */
                if(dp[j] && j + nums[j] >= i){
                    dp[i] = true;
                    break;
                }
            
        
        return dp[nums.length-1];
    }
}
