package medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * > PROBLEM 15 (medium): Three Sum
 *   Given an integer array "nums" return all triplets
 *   [nums[i], nums[j], nums[k]] with j != i != k such that 
 *   nums[i] + nums[j] + nums[k] = 0. 
 *   Notice that the solution set must not contain duplicate triplets
 * 
 * > NOTE: 
 *   The optimal in time but suboptimal in space exploit a map and 
 *   the problem Two Sum. we are looking for a triplet a, b, c such that 
 *   a + b + c = 0, which also means that a + b = -c.
 *   if we see -c as the target this is exactly two sum. 
 * 
 * > SOLUTION: 
 *   Here we use the two pointer trick. First thing we sort of the array, 
 *   then we go through the array from left to right using the index i.
 *   For each i we use two pointers j and k that are at the opposite sides: 
 *   j is right next to i and k is at the rightmost and go backwards. 
 *   Basically we assume i as the first element of the triplet, then j and k 
 *   go either right (j) or left (k) if the sum of the three elements is bigger
 *   or lesser than zero: if > 0 we decrease k, if < 0 we increase j
 */
public class ThreeSum {
    public static void main(String[] args) {
        //test 1
        List<List<Integer>> output1 = solution(new int[]{-1,0,1,2,-1,-4});
        output1.get(0).equals(Arrays.asList(new int[]{-1,-1,2}));
        output1.get(1).equals(Arrays.asList(new int[]{-1,0,1}));
        //test 2
        assert(solution(new int[]{0,1,1}).size() == 0);
        //test 3
        List<List<Integer>> output3 = solution(new int[]{0,0,0});
        output3.get(0).equals(Arrays.asList(new int[]{0,0,0}));
    }

    public static List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            //this avoid i to refer to the same value twice, to avoid duplicates
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1;
            int k = nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    //here we found a triplet
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]); triplet.add(nums[j]); triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    
                    //this avoid j to refere to the same value twice, to avoid duplicates
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                }else if(nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}
