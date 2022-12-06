package easy;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 169 (easy): Majority Element
 *   Given an array "nums" of size n, return the majority element.
 *   The majority element is the element that appears more than 
 *   the floor of n/2
 * 
 * > SOLUTION: 
 *   We have to exploit the following property: if we divide an array 
 *   into two halves and if the two halves have the same majority
 *   element than the array itself has that majority element.
 *   Mind that we divide using indexes and not by passing copies of subarrays 
 *   because that costs time and space.
 * 
 * > NOTE: 
 *   This is not the best possible solution as it have time complexity
 *   O(nlogn) as the basic idea is taken from mergesort. The space complexity is 
 *   O(log n) since, even if we do not allocate anything new, space is used by the
 *   stack frames of the recursive calls. Since the algorithm cuts in half the array 
 *   at each level of recursion we have that there can only be O(logn) cuts before 
 *   the base case of 1 is reached.
 *      - the best possible solution is O(n) time and O(1) space 
 *        and it is done using the Boyer-Moore Voting Algorithm
 */
public class MajorityElement {
    public static void main(String[] args) {
        assertTrue(solution(new int[]{3, 2, 3}) == 3);
        assertTrue(solution(new int[]{2,2,1,1,1,2,2}) == 2);
    }

    public static int solution(int[] nums){
        return helper(nums, 0, nums.length-1);
    }

    /**
     * @param nums the array of which we want the majority element
     * @param start the start of the array
     * @param end the end of the array
     * @return the majority element of the passed array
     */
    public static int helper(int[] nums, int start, int end){
        //base case: array of size 1, the majority element is the only element
        if(start == end)
            return nums[start];

        //recurse to compute the left half and right half majority elements
        int mid = (start + end)/2;
        int leftMajority = helper(nums, start, mid);
        int rightMajority = helper(nums, mid+1, end);

        //if the magiority element of the halves coincide than we return
        if(leftMajority == rightMajority)
            return leftMajority;

        //otherwise count the occurrences and return the winner
        int leftMajorityCount = count(nums, leftMajority, start, end);
        int rightMajorityCount = count(nums, rightMajority, start, end);

        if(leftMajorityCount > rightMajorityCount)
            return leftMajority;
        else
            return rightMajority;
    }

   /**
    * @param nums is the array where to count
    * @param element it the element of which we want to count the occourrences
    * @param start is the starting point of the current array portion
    * @param end is the end point of the current array portion
    * @return the number of occurrences of element in the portion between start-end
    */
    public static int count(int[] nums, int element, int start, int end){
        int count = 0; 
        for(int i = start; i <= end; i++)
            if(nums[i] == element)
                count++;

        return count;
    }
}
