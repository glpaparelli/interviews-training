package problems.dynamicprogramming;
/*
 * > PROBLEM 70 (easy): Climbing Stars
 * //TODO
 */
public class ClimbingStars {
    public static int solution(int n){
        int[] dp = new int[n+1];

        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
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
