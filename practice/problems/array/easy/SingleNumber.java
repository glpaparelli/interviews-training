package easy;
/*
 * > PROBLEM 136 (easy): Single Number
 *   Given a non-empty array of integers nums, every element appears twice execpt for one. 
 *   Find that single one. 
 *   
 *   You Must implement a solution with a linear runtime complexity and use only constant 
 *   extra space. 
 * 
 * > SOLUTION:
 *   We use some bit manipulation: ^ is the XOR, and it works on every primitve data, not just
 *   on boolean. It perform the xor bitwise. 
 * 
 *   We recal some properties of the XOR
 *      - A xor 0 = A
 *      - A xor A = 0
 * 
 *   Basically XOR flat duplicates: every number that has a duplicate will give 0, 
 *   the only number that has not a duplicate will be in xor with zero, which result 
 *   in the number itself.
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,2,1}));
        System.out.println(solution(new int[]{1,4,2,1,2}));
        System.out.println(solution(new int[]{1}));
    }


    public static int solution(int[] nums){
        if(nums.length == 1)
            return nums[0];
        
        int result = 0;
        for(int num : nums)
            result = result ^ num;

        return result; 
    }
}
