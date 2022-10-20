package problems.dynamicprogramming;
/*
 * > PROBLEM 70 (easy): Climbing Stars
 *   You are climbing a staircase. It takes n steps to reach the top. 
 *   Each time you can either climb 1 or 2 steps. In how many distinct ways
 *   can you clim to the top? 
 * 
 * > SOLUTION: 
 *   Classic bottom up dynamic programming solution: see the commented code.
 */
public class ClimbingStars {
    public static void main(String[] args) {
        assert(solution(2) == 2);
        assert(solution(3) == 3);
    }

    public static int solution(int n){
        int[] dp = new int[n+1];

        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        // base cases
        dp[0] = 0; 
        dp[1] = 1;
        dp[2] = 2;

        /*
            to reach the i-th step we can simply sum the number of ways needed 
            to reach the (i-1)-th and (i-2)-th step: the problem states that 
            we either do a single step or two alltogheter. 
            Then to reach the i-th step we can use all the moves needed to reach 
            the (i-1)-th step and then make one step further or we can use all the 
            moves needed to reach the (i-2)-th step and make a 2 step move.
        */
        for(int i = 3; i <=n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
}
