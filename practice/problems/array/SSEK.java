package problems.array;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 560 (medium): Subarray Sum Equals k
 *   Given an array of integers "nums" and an integer "k",
 *   return the total number of subarrays whose sum equals to k.
 * 
 *   A subarray is a contiguos non-empty sequence of elements of the array
 * 
 * > SOLUTION:
 *   We use a map to achieve the best possible performance. 
 *   The algorithm is described as follows:
 *   1) Traverse the array and keep track of the current running sum up to 
 *      the i-th index in a variable, say sum.
 *   2) Also hash the different values of sum obtained so far in the map.
 *   3) If sum == k at any point of the array increment the count of subarrays
 *      of sum k by one.
 *   4) If this value of sum has exceeded k by a value of sum – k, we can find 
 *      the number of subarrays, found so far with sum = sum – k, from our hashmap. 
 *      Observe that if these subarrays are deleted from our current array, we will 
 *      again obtain a sum of k. 
 *      So, we add to our answer, the number of subarrays with sum = sum – k found 
 *      so far from our hashmap.
 *   5) After traversing through the entire array once and applying the above steps,
 *       return the calculated result.
 */
public class SSEK {
    public static void main(String[] args) {
        assert(solution(new int[]{1,1,1}, 2) == 2);
        assert(solution(new int[]{1,2,3}, 3) == 2);
    }

    public static int solution(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;

        for(int num : nums){
            sum = sum + num;
            if(sum == k)
                count++;
            
            if(map.containsKey(sum - k))
                count = count + map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}
