package medium;
/*
 * > PROBLEM 122 (medium): Best Time to Buy and Sell Stock II
 *   You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *   
 *   On each day, you may decide to buy and/or sell the stock. You can only hold at most one 
 *   share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * 
 *   Find and return the maximum profit you can achieve.
 * 
 * > SOLUTION: 
 *   1) Valley and Peaks
 *   The max profit is given by finding the current minimum, the maximum maximum 
 *   just after the found minimum and subtracting those. 
 *   
 *   2) One Pass
 *   The previous method can be furtherly abstracted: every time we have a profit
 *   in consecutive days we get it (if yesteday we paid a stock less then how it is 
 *   worth today then we sell it today)
 *   At the end we will reach the maximum possible profit
 */
public class BTtBaSS2 {
    public static int solution(int[] prices){
        int maxProfit = 0;
        int i = 0; 

        int valley = prices[0];
        int peak = prices[0];

        while(i < prices.length -1){
            while(i < prices.length -1 && prices[i] >= prices[i+1])
                i++;

            valley = prices[i];

            while(i < prices.length -1 && prices[i] <= prices[i+1])
                i++;

            peak = prices[i];

            maxProfit = maxProfit + (peak - valley);
        }

        return maxProfit;
    }

    public static int onePassSolution(int[] prices){
        int maxProfit = 0; 
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i-1])
                maxProfit = maxProfit + (prices[i] - prices[i-1]);

        return maxProfit;
    }
}
