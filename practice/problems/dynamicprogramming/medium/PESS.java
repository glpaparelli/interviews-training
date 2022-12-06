package problems.dynamicprogramming.medium;
import java.util.Arrays;
/*
 * > PROBLEM 416 (medium): Partial Equal Subset Sum
 *   Given a non-empty array "nums" containing only positive integers, find if
 *   the array can be partiotioned into two substes such that the sum of elements
 *   in both substes is equal.
 * 
 *   - Example
 *      - input: nums = [1,5,11,5]
 *      - output: true
 *          - explaination: the array can be partitioned as [1,5,5] and [11]
 */
public class PESS {
    public static void main(String[] args) {
        int[] input1 = {1,5,11,5};
        int[] input2 = {1,2,3,5};

        assert(solution(input1));
        assert(solution(input2));
    }

    // side note: we can also optimize further, it is 
    // possible to use the same apporach but with just 1D dp.
    public static boolean solution(int[] nums){
        /*
            to create two substes of equal sum we have to split
            the sum of the whole array in two: if the sum is odd
            then it is impossible to have two equal "halves"
        */
        int size = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if(target % 2 != 0)
            return false;
    
        /*
            Now we have to see if there is a possible sum of elements in nums 
            that is equal to target: we have to divide the array in two substes, 
            if we can find 1 subset with sum = target it obviously means that the
            other substes has the same sum.
    
            Here we use the bottom-up dynamic programmng approach: 
            - dp[i][j] = true --> the first i elements in nums sum up to the number j
            - the base case is dp[0][0] is true (zero number consits of sum 0) is true
            - the transition function: 
                - for each number nums[i]:
                    - if we don't pick it: dp[i][j] = dp[i-1][j], which means 
                      that if the first i-1 elements sums up to j, dp[i][j]
                      would also make it to j (hence we can ignore nums[i])
                    - if we pick it: dp[i][j] = dp[i-1][j-nums[i]], which means 
                      that the first i numbers sum up to j if the first i-1 numbers
                      sum up to j-nums[i], which is obvious      
                > thus the transition function is: 
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
                    - said easly: the first numbers i sums up to j if one of the option is true
                        1) the first i-1 numbers already sums up to j and we can ignore the i-th
                        2) the first i-1 numbers sums up to j-nums[i], which means that with
                           the i-th number we get j           
        */
        
        boolean[][] dp = new boolean[size+1][sum+1];

        // fill the whole matrix with false everywhere
        for(boolean[] row : dp)
            Arrays.fill(row, false);
        
        // base case: with 0 numbers is always possible to add up to 0
        for(boolean[] row : dp)
            row[0] = true;
        
        // base case: with 0 numbers is always impossible to add up to j with j >= 1
        for (int j = 1; j < sum+1; j++) 
            dp[0][j] = false;
        
        // real case:
        for (int i = 1; i < size+1; i++) 
            for (int j = 1; j < sum+1; j++) 
                // as described before
                // - before || : first case, we skip number i
                // - after || : the if is to avoid index out of bound, we take num i
                dp[i][j] = dp[i-1][j] || ((j >= nums[i-1]) ? dp[i-1][j-nums[i-1]] : false);
        
        return dp[size][sum];       
    }
}
