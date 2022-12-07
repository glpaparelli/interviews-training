package easy;

import java.util.Arrays;

/*
 * > PROBLEM 66 (easy): Plus One
 *   You are given a large integer represented as an integer array digits, where each digits[i]
 *   is the ith digit of the integer. The digits are ordered from most significant to least 
 *   significant in left-to-right order. The large integer does not contain any leading 0's.
 *   
 *   Increment the large integer by one and return the resulting array of digits.
 * 
 * > SOLUTION: 
 *   Trivial solution, read the code
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution(new int[]{9})));
    }

    public static int[] solution(int[] digits){
        int length = digits.length;

        if(length == 1 && digits[0] == 9)
            return new int[]{1,0};

        // plus 1: we add on the least signifcant digit. if not 9
        // dont even have the carry and the result is trivial
        if(digits[length-1] != 9)
            digits[length-1]++;
        else{
            boolean carry = true;
            // there is a carry, so the last element surely becomes 9
            digits[length-1] = 0;

            // for each digit "after" the 9
            for(int i = length-2; i >= 0; i--)
                // if also 9 the carry is propagated
                if(digits[i] == 9)
                    digits[i] = 0; 
                else{
                    // once we find where to apply the 
                    // carry increment and exit the loop
                    digits[i] = digits[i] + 1;
                    carry = false; 
                    break;
                }
            
            // if the carry was propagated for the whole number it
            // means that we have all digits = 9 and we have to 
            // create a bigger array 
            // eg: [9,9,9] + 1 -> [1,0,0,0]
            if(carry == true){
                digits = new int[length+1];
                Arrays.fill(digits, 0);
                digits[0] = 1;
            }
        }

        return digits; 
    }
}
