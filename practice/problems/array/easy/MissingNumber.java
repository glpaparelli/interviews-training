package easy;
/*
 * > PROBLEM 268 (easy): Missing Number
 *   Given an array nums containing n distinct integers in the range [0,n], return the
 *   only number in range that is missing from the array; 
 * 
 * > SOLUTION: 
 *   trivial: get the sum of the first n integers, subtract every element in the array 
 *   and the remaining will be the missing number
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,1}));
        System.out.println(solution(new int[]{0,1}));
        System.out.println(solution(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int solution(int[] nums){
        int result = (nums.length * (nums.length+1)) / 2;

        for(int num : nums)
            result = result - num;

        return result; 
    }
}
