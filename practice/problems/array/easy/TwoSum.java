package easy;
import static org.junit.Assert.assertArrayEquals;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 1 (easy): Two Sum
 *   Given an array of integers "nums" and an integer 
 *   "target" return indices of the two numbers in the array such
 *   that they add up to "target".
 *      - you may assume that each input would have exactly one
 *        solution and you may not use the same element twice
 *      - you can return the answer in any order
 * 
 * > SOLUTION: 
 *   We use a map where the keys are the values of the array 
 *   and the values associated to the keys are the indexes of the
 *   values in the array
 *      - eg: nums = [3, 2, 5], map =  3 -> 0, 2 -> 1, 5 -> 2
 *   We can solve the problem in one passage of the array: while building
 *   the map we also look up on it. 
 *   This will result in a "reversed solution" (if target = a + b and a is 
 *   the first element in the array we will not find the solution until 
 *   we inspect nums[i] = b and find the complement a in the map, 
 *   that's why {map.get(complement), i})
*/
public class TwoSum {
    public static void main(String[] args) {
        assertArrayEquals(solution(new int[]{2,7,11,15}, 9), new int[]{0,1});
        assertArrayEquals(solution(new int[]{3,2,4}, 6), new int[]{1,2});
        assertArrayEquals(solution(new int[]{3,3}, 6), new int[]{0,1});
    }

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complementIndex;
        
        for(int i = 0; i < nums.length; i++){
            complementIndex = map.getOrDefault(target-nums[i], -1);

            if(complementIndex != -1)
                return new int[] {complementIndex, i};
            
            map.put(nums[i], i);
        }
        return null;
    }
}
