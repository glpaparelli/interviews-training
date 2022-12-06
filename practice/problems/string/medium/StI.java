package problems.string.medium;
/*
 * > PROBLEM 8 (medium): String to Integer (ATOI)
 *   Implement the myAtoi(string s) function, which converts a string 
 *   to a 32-bit signed integer (similar to C/C++'s atoi function).
 * 
 *   The algorithm for solution(string s) has to follow these steps:
 *   - Read in and ignore any leading whitespace.
 *   - Check if the next character (if not already at the end of the string) 
 *     is '-' or '+'. Read this character in if it is either. 
 *     This determines if the final result is negative or positive respectively. 
 *     Assume the result is positive if neither is present.
 *   - Read in next the characters until the next non-digit character or the 
 *     end of the input is reached. The rest of the string is ignored.
 *   - Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
 *     If no digits were read, then the integer is 0. 
 *     Change the sign as necessary (from step 2).
 *   - If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], 
 *     then clamp the integer so that it remains in the range. Specifically, 
 *     integers less than -2^31 should be clamped to -2^31, and integers greater 
 *     than 2^31 - 1 should be clamped to 2^31 - 1.
 * 
 * > SOLUTION: 
 *   Just follow the steps of the algorithm
 */
public class StI {
    public int solution(String s) {
        if(s.isEmpty() || s.isBlank())
            return 0;

        // step 1
        s = s.trim();

        // step 2
        int sign = 1;
        int start = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            start++;
        }else if(s.charAt(0) == '+')
            start++;

        // step 3,4,5
        int total = 0;
        while (start < s.length() && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            int digit = s.charAt(start) - '0';

            if (total > (Integer.MAX_VALUE - digit) / 10) 
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            total = total * 10 + digit;
            start++;
        }
        return sign * total;
    }
}
