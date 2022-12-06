package medium;
import static org.junit.Assert.assertArrayEquals;
/*
 * > PROBLEM 238 (medium): Product of Array Except Self
 *   Given an array "nums" return an array "answer" such that
 *   answer[i] is equal to the product of all the elements of nums 
 *   except nums[i]. 
 *   The product of any prefix or suffix of nums is guaranted to fit in
 *   a 32-bit integer. 
 *   You must write an algorirhm that runs in O(n) time without using
 *   the division operator.
 * 
 * > SOLUTION: 
 *   We use a preprocessing technique to compute the prefix product of the element
 *   in position i and the suffix product of the element in position i.
 *   The result answer[i] will simply be prefix of element i * suffix of element i. 
 *   This can be done without intantiating prefix[] and suffix[] by computing them
 *   in two passage of the array nums, using two "accumulators" 
 *      - we could even use only one accumulator: fill answer with 1s, create a variable
 *        tmp = 1 and use it in the first for in place of prefix. Then set tmp = 1 and
 *        use it in place of suffix in the second for. I choose to use two vars because
 *        it's more clear
   */
public class PoAES {
    public static void main(String[] args) {
        assertArrayEquals(solution(new int[]{1,2,3,4}), new int[]{24,12,8,6});
        assertArrayEquals(solution(new int[]{-1,1,0,-3,3}), new int[]{0,0,9,0,0});
    }

    public static int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        
        // use prefix to store in answer[i] the suffix product of the i-th element
        int prefix = 1; 
        for(int i = 0; i < nums.length; i++){
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        // use suffix to store in answer[i] the suffix product of the i-th element
        int suffix = 1;
        for(int i = nums.length -1; i >= 0; i--){
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return answer;
    }
}
