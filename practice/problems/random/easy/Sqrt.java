package problems.random.easy;
/*
 * > PROBLEM 69 (easy): Square root of x
 *   Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
 *   The returned integer should be non-negative as well.
 * 
 *   You must not use any built-in exponent function or operator.
 * 
 * > SOLUTION: 
 *   newton method
 */
public class Sqrt {
    public static int solution(int x){
        long result = x; 

        while(result * result > x)
            result = (result + x/result) / 2;

        return (int) result; 
    }
}
