package problems.array;
/*
    > problem: Best Time to Buy and Sell Stock
    You are given an array "prices" where prices[i] is the
    price of a given stock at the i-th day. 
    You want to maximize your profit by choosing a single day to 
    buy one stock and choosing a different day in the future to sell 
    that stock. 
    Return the maximum profit you can achieve from this transaction, 
    if you cant achieve any profit return 0.

    > idea: we just need to find the smallest element that is follwed
    by the biggest one. To do this we simply keep track of the current
    minimum while checking the array, then if the current element
    is not smaller than the minimum we check if it improves our profit
*/
public class BTtBaSS {
    public static void main(String[] args) {
        assert(solution(new int[]{7,1,5,3,6,4}) == 5);
        assert(solution(new int[]{7,6,4,3,1}) == 0);
    }

    public static int solution(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        //we go through the whole array
        for(int i = 0; i < prices.length; i++){
            //we find the minimum until this point
            if(prices[i] < minPrice)
                minPrice = prices[i];
            //if the current element is not the minimum than 
            //it could be the maximum and it is surely after the
            //minimum: this element improves my profit?
            else if(prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
