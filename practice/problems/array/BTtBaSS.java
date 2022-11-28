package problems.array;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 121 (easy): Best Time to Buy and Sell Stock
 *   You are given an array "prices" where prices[i] is the
 *   price of a given stock at the i-th day. 
 *   You want to maximize your profit by choosing a single day to 
 *   buy one stock and choosing a different day in the future to sell 
 *   that stock. 
 *   Return the maximum profit you can achieve from this transaction, 
 *   if you cant achieve any profit return 0.
 * 
 * > SOLUTION: 
 *   We just need to find the smallest element that is followed by 
 *   the biggest one. 
 *   We keep track of the current minimum price while inspecting every
 *   price. If the current price is not smaller than the min price we 
 *   check if it improves our profit
 */
public class BTtBaSS {
    public static void main(String[] args) {
        assertTrue(solution(new int[]{7,1,5,3,6,4}) == 5);
        assertTrue(solution(new int[]{7,6,4,3,1}) == 0);
    }

    public static int solution(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // we go through every price
        for(int currentPrice : prices)
            // we keep track of the current minimum price
            if(currentPrice < minPrice)
                minPrice = currentPrice;
            else
                // if the current price is not the minimum price then 
                // it could be the maximum and it is surely after the 
                // minimum price: this price improve my profit?
                maxProfit = Math.max(maxProfit, currentPrice - minPrice);
          
        return maxProfit;
    }
}