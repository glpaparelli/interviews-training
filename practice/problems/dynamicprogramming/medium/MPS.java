package problems.dynamicprogramming.medium;
/*
 * > PROBLEM 152 (medium): Maximum Product Subarray
 *   Given an array of integer "nums", find a contiguous non-empty subarray
 *   whithin the array that has the largest product, and return the product. 
 * 
 *   The test cases are generated so that the answer will fit in a 32-bit 
 *   integer. 
 *   A subarray is a contiguos subsequence of the array.
 * 
 * > SOLUTION: 
 *   bottom-up dynamic programming, read the comments.
 */
public class MPS {
    public static void main(String[] args) {
        int[] input1 = {2,3,-2,4};
        assert(solution(input1) == 6);

        int[] input2 = {-2,0,-1};
        assert(solution(input2) == 0);
    }

    public static int solution(int[] nums){
        if(nums.length == 0)
            return -1; 
        if(nums.length == 1)
            return nums[0];

        int result = Integer.MIN_VALUE;

        /*
            maxProd[i] = maximum product of the subarray that ends with i. 
            minProd[i] = minimum product of the subarray that ends with i. 
            
            minProd is needed because a negative number can be used to create the MPS 
            if multiplied with another negative number
        */
        int[] maxProd = new int[nums.length];
        int[] minProd = new int[nums.length];

        // base cases: the max/min product we can have with the first smallest subarray, which is 
        // the first element alone, is the first element itself.
        maxProd[0] = nums[0];
        minProd[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            // Math.max(maxProd[i-1] * nums[i], Math.max(minProd[i-1] * nums[i], nums[i]));
            
            /*
                How we update the dp array? 
                - remember that maxProd[i] = maximum product of the subarray that ends at the index i
                    - so the key is: how we move the start of the subarray? 
                maxProd[i] is the max between
                    - the product of the current number and the previous max product (the product of the 
                      subarray that ended at i-1)
                    - the product of the current number with the previous minimum product (the min product
                      of the subarray that ended at i-1)
                        - this is because a small product can become max: -10 can become 20 if nums[i] = -2
                    - the current number nums[i]
                        - say that nums is [-1, 3, ...]
                            - we have that maxProd[0] = minProd[0] = -1
                            - i = 1: we reset maxProd (and minProd)
                                - maxProd[1] = max(maxProd[0] * nums[1] (-3), minProd(0) * nums[1] (-3), 3)
                                    - maxProd[1] = 3, because at this point the subarray with max product is the
                                      subarray that starts (and ends) at 1 -> 3.
            */
            maxProd[i] = max(maxProd[i-1] * nums[i], minProd[i-1] * nums[i], nums[i]);
            
            // minProd[i] = Math.min(maxProd[i-1] * nums[i], Math.min(minProd[i-1] * nums[i], nums[i]));
            minProd[i] = min(maxProd[i-1] * nums[i], minProd[i-1] * nums[i], nums[i]);
        }

        for(int prod : maxProd)
            result = Math.max(result, prod);
        
        return result;
    }

    static private int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    static private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }


}
