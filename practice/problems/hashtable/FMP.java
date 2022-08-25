package problems.hashtable;
/*
 * > PROBLEM 41 (hard): First Missing Positive
 *   Given an unsorted integer array "nums", return the smallest
 *   missing positive integer. 
 *   
 *   You must implement an algorithm that runs in O(n) time and 
 *   uses constant extra space
 * 
 * > SOLUTION: 
 *   > Just the Idea
 *     To use constant extra space we have to transform nums into a map. 
 *     We notice an important property
 *      - negative numbers, zeroes and numbers >= nums.length are useless
 *         - in particular: for the pidgeon hole principle if a position 
 *           in nums is used for a number > nums.length then surely there 
 *           is in nums a num > 0 smaller than nums.length
 *      - hence we transform every numer that is <= 0 to nums.length +1 
 *     Now, for every number that is < nums.length we put nums[nums[i]] = - nums[i].
 *     Then, for every i = 0 to nums.length, if nums[i] > 0 means that i is not 
 *     in nums, hence we return i
 */
public class FMP {
    public static void main(String[] args) {
        assert(solution(new int[]{1,2,3}) == 3);
        assert(solution(new int[]{3,4,-1,1}) == 2);
        assert(solution(new int[]{7,8,9,11,12}) == 1);
    }

    public static int solution(int[] nums){
        for(int i = 0; i < nums.length; i++)
            if(nums[i] <= 0) 
                nums[i] = nums.length + 1;

        // the value of the array becomes the index
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            // index -1 because the whole array is shifted 
            // since the value 0 has no meaning for us
            if(index-1 < nums.length && nums[index-1] > 0) 
                nums[index-1] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++) 
            if (nums[i] > 0)
                return i + 1;

        return nums.length + 1;
    }
}
