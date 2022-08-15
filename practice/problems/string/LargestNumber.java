package problems.string;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
/*
 * > PROBLEM 179 (medium): Largest Number
 *   Given a list of non-negative integers "nums", arrange them such that
 *   they form the largest number and return it.
 *   
 *   Since the result may be very large, so you need to return a string 
 *   instead of an integer.
 * 
 * > SOLUTION: 
 *   To build the largest number we have to ensure that the most significant 
 *   digits are occupied by the largest digits.
 *   First we convert every element of the array into a string, sort 
 *   the array using the custom comparator (that compare a + b vs b + a), and 
 *   then join every string to obtain the biggest integer as string 
 */
public class LargestNumber {
    public static void main(String[] args) {
        assert(solution(new int[]{10,2}).equals("210"));
        assert(solution(new int[]{3,30,34,5,9}).equals("9534330"));
    }

    private static class myComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String solution(int[] nums) {
        // get input integers as strings.
        String[] numsAsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) 
            numsAsStrings[i] = String.valueOf(nums[i]);
        
        // sort strings according to custom comparator.
        Arrays.sort(numsAsStrings, new myComparator());

        // if, after sort, the largest number is `0`, the entire number is zero.
        if (numsAsStrings[0].equals("0")) 
            return "0";

        return Arrays.stream(numsAsStrings).collect(Collectors.joining());
    }
}
