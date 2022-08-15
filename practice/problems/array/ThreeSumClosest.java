package problems.array;
import java.util.Arrays;
/*
 * > PROBLEM 16: 3Sum Closest
 *   Given an integer array "nums" of length n and an integer 
 *   "target", find three integers in nums such that the sum is 
 *   closest to target. 
 *   Return the sum of the three integers. 
 *   You may assume that each input would have exactly one solution.
 * 
 * > SOLUTION: 
 *   A slight variation of 3Sum. We move the indexes j and k 
 *   based on the predicate currentSum <, =, > target
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        assert(solution(new int[]{-1,2,1,-4}, 1) == 2);
        assert(solution(new int[]{0,0,0}, 1) == 1);
    }

    public static int solution(int[] nums, int target){
        Arrays.sort(nums);
        
        int closest = nums[0] + nums[1] + nums[2];
        int current = 0;
        
        for(int i = 0; i < nums.length; i++){
            // skip equals numbers
            if(i != 0 && nums[i-1] == nums[i])
                continue;

            int j = i+1; 
            int k = nums.length -1;

            while(j < k){
                current = nums[i] + nums[j] + nums[k];
                if(current == target)
                    return nums[i]+nums[j]+nums[k];
                else if(current < target)
                    j++;
                else
                    k--;
            }
            if(Math.abs(closest - target) >= Math.abs(current - target))
                closest = current;    
        }
        return closest;
    }
}
