package hard;
/*
 * > PROBLEM 123 (hard): Best Time to Buy and Sell Stock III
 *   You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 *   Find the maximum profit you can achieve. You may complete at most two transactions.
 * 
 *   Note: You may not engage in multiple transactions simultaneously 
 *   (i.e., you must sell the stock before you buy again).
 */
public class BTtBaSS3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    /*
        the idea is simple: get the max possible profit from the first 
        transaction then we admortize the price with the amount
        that we already gained from the first transaction. 

        basically with two transaction available the way to have the max profit
        - do the most profitable first transaction
        - use what you have now to get the most profit from the second transaction 
    */
    public static int solution(int[] prices){
        int minPrice1 = Integer.MAX_VALUE; 
        int minPrice2 = Integer.MAX_VALUE;
        int profit1 = 0; 
        int profit2 = 0;

        for(int currentPrice : prices) {
            minPrice1 = Math.min(currentPrice, minPrice1);
            profit1 = Math.max(profit1, currentPrice - minPrice1);

            minPrice2 = Math.min(minPrice2, currentPrice - profit1);
            profit2 = Math.max(profit2, currentPrice - minPrice2);
        }

        return profit2;
    }
}
