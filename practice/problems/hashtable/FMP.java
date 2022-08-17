package problems.hashtable;

import java.util.Arrays;

/*
 * > PROBLEM 41 (hard): First Missing Positive
 *   //TODO
 */
public class FMP {

    public static void main(String[] args) {
        System.out.println("RESULT: " + solution(new int[]{1,2,0}));
    }

    public static int solution(int[] nums){

        if(!Arrays.stream(nums).anyMatch(x -> x == 1))
            return 1;

        for(int i = 0; i < nums.length; i++)
            if(nums[i] <= 0) 
                nums[i] = nums.length + 1;

        for(int i = 1; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            if(index < nums.length && nums[index] > 0) 
                nums[index-1] *= -1;
        }
            
        for(int i = 0; i < nums.length; i++) 
            if (nums[i] > 0)
                return i + 1;
        
        return nums.length + 1;
    }
        
}
