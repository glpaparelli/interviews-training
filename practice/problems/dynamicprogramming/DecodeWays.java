package problems.dynamicprogramming;
/*
 * > PROBLEM 91 (medium): Decode Ways
 *   A message containing letters from A-Z can be encoded into numbers using 
 *   the following mapping: 
 *      'A' -> "1"
 *      'B' -> "2"
 *      ... 
 *      'Z' -> "26"
 * 
 *   To decode an encoded message, all digits must be grouped then mapped back into
 *   letters using the reverse of the mapping above (there may be multiple ways). 
 *   For example, "11106" can be mapped into: 
 *      - "AAJF" with the grouping 1 1 10 6
 *      - "KJF" with the grouping 11 10 6
 * 
 *   Note that the grouping 1 11 06 is invalid because "06" cannot be mapped into
 *   'F' since "6" is different from "06". 
 * 
 *   Given a string s containing only digits, return the number of ways to decode it. 
 * 
 * > SOLUTION: Dynamic Programming
 *   check the comments
 *   
 */
public class DecodeWays {
    public static void main(String[] args) {
        assert(solution("12") == 2);
        assert(solution("226") == 3);
        assert(solution("06") == 0);
    }
    public static int solution(String s){
        if(s.charAt(0) == '0')
            return 0; 

        int sLength = s.length();

        // dp[i] = #ways to decode the substring from 0 to i, everything shifted by 1
        int[] dp = new int[sLength+1];

        // base case 
        dp[0] = 1;
        
        for(int i = 1; i <= sLength; i++){
            // check the single digit decodification,
            // which is possible only if the previous char s[i-1] was not zero
            
            // remember that everything is shifted by 1: dp[i] is about the char i-1
            if(s.charAt(i-1) != '0')
                dp[i] = dp[i-1];

            // now check the double digit decode by looking 
            // at the previous two digits. If the substring
            // obtained belong to the range [10 - 26]
            // then add the previous state dp[i-2]
            if(i >= 2){
                int x = Integer.parseInt(s.substring(i-2, i)); 
                if(x >= 10 && x <= 26)
                    dp[i] = dp[i] + dp[i-2];
            }

        }

        return dp[sLength];
    }
}
