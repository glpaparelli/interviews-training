package problems.dynamicprogramming;
import java.util.Arrays;
/*
 * > PROBLEM 322 (medium): Coin Change
 *   You are given an integer array "coins" representing coins of different 
 *   "cuts" and an integer "amount" representing a certain amount of money. 
 *   Return the fewest number of coins that you need to make up the amount. 
 *   If that amount of money cannot be made up by any combinations of the 
 *   coinsm return -1. 
 * 
 *   You may assume that you have an infinite number of each king of coin. 
 * 
 *   - example:
 *      - input: coins = [1,2,5], amount = 11
 *      - output: 3
 *          - explaination: the amount 11 can be made up using 2 coin of 5 and one 
 *            coin of 1, 11 = 5 + 5 + 1
 * 
 * > SOLUTION 1: DP TOP-DOWN
 *   First of all we define F(S) as the minimum number of coins needed to make change
 *   for the amount S using coin cuts [c_0, c_1, ..., c_n-1]. 
 *   We note that this problem has an optimal substructure property, which is the key
 *   piece in solving any DP problem: the optimal solution can be constructed from 
 *   the optimal solutions of its subproblems. 
 *   
 *   How to split the problem into subproblems? Let's assume that we know F(S) where
 *   some change val_1, val_2, ... for S which is optimal and the last coin's cut is C.
 *   Then the following equation should be true because of the optimal substructure of
 *   the problem: 
 *      F(S) = F(S - C) + 1
 *   
 *   The problem is that we do not know which is the cut of the last coin C.
 *   Then we compute F(S - c_i) for each possible cut in coins and we choose the minimum 
 *   among them.
 *   The following recurrence relation holds: 
 *      - F(S) = min_i=0,n-1 F(S - c_i) + 1 provided that S - c_i >= 0
 *   with 
 *      - F(S) = 0 when S = 0
 *      - F(S) = -1 when n = 0
 * 
 *   The algorithm builds the solution of the problem from top to bottom. 
 *   It applies the idea above, it uses backtracking and cut the partial solutios
 *   in the recursive tree that do not leat to a viable solution. This happen when we
 *   try to make a change of a coin with a value greater that the amoun S. 
 *   
 *   > SOLUTION 2: DP BOTTOM-UP
 *   For an iterative solution we can think in bottom-up manner. Before calculating
 *   F(i) we have to compute all minimum counts for amounts up to i (for each amount i
 *   from zero to amount we have to compute the min numbers of coins to change the 
 *   amount i). On each iteration i of the algorithm F(i) is computed as
 *      - F(i) = min_i=0,n-1 F(i - c_i) + 1
 */
public class CoinChange {

    //TODO main

    public int solutionTopDown(int[] coins, int amount){
        if(amount < 1)
            return 0; 
        
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int amountLeft, int[] dp) {
        // dp[i] = #coins needed to change the amount i

        if(amountLeft < 0)
            return -1;
        //to change 0 we need 0 coins
        if(amountLeft == 0)
            return 0;
        
        if(dp[amountLeft -1] != 0) 
            return dp[amountLeft-1];

        int min = Integer.MAX_VALUE;

        for(int coin : coins){
            // res = min #coin needed to represent the amount "amountLeft - coin"
            // to change the amount "amountLeft" we can compute the number of coins
            // needed to change the amount "amountLeft - coin", then add 1, which is 
            // the same coin. If this number of coins is smaller than the prev min we 
            // found a new min
            int res = helper(coins, amountLeft - coin, dp);
            if(res >= 0 && res < min)
                min = res + 1;
        }

        // store the amount of coin needed to change the amount "amount left - coin"
        dp[amountLeft - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amountLeft - 1];
    }

    public static int solutionBottomUp(int[] coins, int amount) {
        int max = amount + 1;

        // dp[i] = min #coin needed to change the amount i
        // we compute the min #coin for each amount from 0 to the target amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0; // to change the amount 0 are needed 0 coins

        // for each amount i
        for(int i = 1; i <= amount; i++) 
            // for each coin j
            for(int j = 0; j < coins.length; j++) 
                // if the coin j is <= amount i then
                if(coins[j] <= i) 
                    // the min #coin needed for the amoun i is the 
                    // minimum between its current value and the 
                    // coins needed to change the value i - coin j
                    // > dp[i - coin j] = #coin needed to change i - coin j
                    // > dp[i - coin j] + 1 (another coin j) = #coin to change i
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
    
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
