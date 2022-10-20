package problems.dynamicprogramming;
/*
 * > PROBLEM 377 (medium): Combination Sum IV
 *   Given an array of distinct integers nums and a target integer target, return 
 *   the number of possible cominations that add up to target. 
 * 
 *   Example: 
 *   - input: nums = [1,2,3], target = 4
 *   - output: 7
 *      - explaination: the possible combinations ways are 
 *          - (1,1,1,1)
 *          - (1,1,2)
 *          - (1,2,1)
 *          - ...
 * 
 *      - note that different sequences are counted as different combinations
 * 
 * > SOLUTION: 
 *   How does the # of combinations of the target related to the # of combinations
 *   that are smaller than the target? 
 *   
 *   We know that target is the sum of numbers in the array. Imagine we only need one 
 *   more number to reach target and this number can be any one in the array. 
 *   
 *   So, the # of combinations of target: 
 *      comb[target] = sum(comb[target-nums[i]]), where i in [0, nums.length] and 
 *      target >= nums[i]
 * 
 *   Let's see an example: 
 *      - input: nums = [1,2,3], target = 4
 *      - output: 7
 *          - we find this solution with the # of combinations of 3 (4-1), 2 (4-2) and
 *            1 (4-3). As a result comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = 
 *            com[3] + comb[2] + comb[1] 
 *   
 */
public class CombinationSumsIV {
    public static void main(String[] args) {
        int[] input1 = {1,2,3};
        assert(solution(input1, 4) == 7);

        int[] input2 = {3}; 
        assert(solution(input2, 3) == 3);
    }

    public static int solution(int[] nums, int target){
        // dp[i] = #combinations to get i
        int[] dp = new int[target + 1];
        // base case: the #combinations to get 0 is just 1, 0 itself
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < nums.length; j++)
                if(i - nums[j] >= 0)
                    dp[i] = dp[i] + dp[i - nums[j]];

        return dp[target]; 
    }
}
