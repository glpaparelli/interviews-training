package hard;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/*
 * > PROBLEM 239 (hard): Sliding Window Maximum
 *   You are given an array of integers "nums", there is a sliding
 *   window of size k which is moving from the very left of the array
 *   from the very right. 
 *   You can only see the k numbers of the window. 
 *   Each time the sliding window moves right by one position. 
 *   
 *   Return the max element for each window. 
 * 
 * > WEIRD SOLUTION
 *   We divide the array in blocks of the size of the window (k). Then 
 *   we create two arrays: maxUntilFromLeft and maxUntilFromRight of the
 *   size of the original array nums:
 *   - maxUntilFromLeft[i] = max element until i from left in the current block
 *   - maxUntilFromRight[i] = max element until i from right in the current block
 *  
 *  An example is the following: 
 *  - nums :[2,1,3,4,6,3,8,9,10,12,56], k = 4
 *    - the blocks are [ 2,1,3,4 | 6,3,8,9 | 10,12,56 ]
 *    - maxUntilFromLeft = [ 2,2,3,4 | 6,6,8,9 | 10,12,56 ]
 *       - at the start of each block the max is the element in that position in nums
 *       - we proceed computing the max in the block for each block
 *    - maxUntilFromRight = [ 4,4,4,4 | 9,9,9,9 | 56,56,56 ]
 *       - the blocks are the same
 *       - we start from the right of nums: for each block we compute the max element 
 *         until that position. As before the element in position "block start" is the 
 *         the element in that position in nums. 
 * 
 *   Now we notice that every window is either equal to a block or a composition of two
 *   two blocks:
 *   - [ <2,1,3,4> ,6,3,8,9,10,12,56 ]: window = 1st block
 *   - [2, <1,3,4,6> ,3,8,9,10,12,56]: window = composition of 1st and 2nd block
 *   - [2,1, <3,4,6,3> ,8,9,10,12,56]]: window = composition of 1st and 2nd block
 *   - ...
 * 
 *   For each window that starts at index i the max of that window is obtained by 
 *   the max between the maxUntilFromRight[i] (aka the first element of the window) 
 *   and the maxUntilFromLeft[i+k-1] (aka the last element of the window)
 * 
 *   - eg: 
 *      - nums = [2,1,3,4,6,3,8,9,10,12,56]; k = 4
 *      - maxUntilFromLeft = [ 2,2,3,4 | 6,6,8,9 | 10,12,56 ]
 *      - maxUntilFromRight = [ 4,4,4,4 | 9,9,9,9 | 56,56,56 ]
 *      
 *      - max of the 1st window (0-3) = max(maxUntilFromRight[0], maxUntilFromLeft[3]) = 4
 *      - max of (1 - 4) = max(maxUntilFromRight[1], maxUntilFromLeft[4]) = 6
 *          - this is the key: since the block division we know that every time we jump 
 *            a block we are looking the maxes in that block.
 *      - ...
 * 
 * > SOLUTION: 
 *   We use a Deque: if we can add and remove elements from both sides of the sliding window, 
 *   we can solve the problem in linear time. In the deque we add and remove indices. 
 *   
 *   For each element nums[i] in the array that we are about to insert, we first check if the leftmost
 *   index in the sliding window is out of bound (kicked by the window). If so we remove it by pollFirst()
 *   in constant time. 
 * 
 *   Then we continuosly remove the rightmost indices if their corresponding elements are less then nums[i], 
 *   which is the element we are about to insert. The idea is that the elements that are less than the element
 *   we'll insert won't have any contributions to the maximum element of the sliding window and it is safe to 
 *   remove them. 
 * 
 *   After removal pollLast() and insertion offerLast(i) (the elements nums[i]), we can say that the leftmost 
 *   element in the window is maximum. 
 */
public class SWM {
    public static void main(String[] args) {
        weirdSolution(new int[]{2,1,3,4,6,3,8,9,10,12,56}, 4);
    }

    public static int[] solution(int[] nums, int k){
        if (nums.length == 0 || k == 0) 
            return new int[0];
        
        int[] result = new int[nums.length - k + 1]; // number of windows
        Deque<Integer> window = new ArrayDeque<>(); // stores indices
        
        for(int i = 0; i < nums.length; i++){
            // remove indices that are out of bound
            while(window.size() > 0 && window.peekFirst() <= i - k) 
                window.pollFirst();
            
            // remove indices whose corresponding values are less than nums[i]
            while(window.size() > 0 && nums[window.peekLast()] < nums[i]) 
                window.pollLast();
            
            // add nums[i]
            window.offerLast(i);
            // add to result
            if(i >= k - 1) 
                result[i - k + 1] = nums[window.peekFirst()];
        }

        return result;
    }

    public static int[] weirdSolution(int[] nums, int k){
        LinkedList<Integer[]> blocks = buildBlocks(nums, k);

        int[] maxUntilFromLeft = buildMaxFromLeft(nums, k, blocks);
        int[] maxUntilFromRight = buildMaxFromRight(nums, k, blocks);
        
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++)
            result[i] = Math.max(maxUntilFromLeft[i + k -1], maxUntilFromRight[i]);
        
        return result;
    }   

    
    private static LinkedList<Integer[]> buildBlocks(int[] nums, int k) {
        LinkedList<Integer[]> blockList = new LinkedList<>();
        // how many full sized block we can have in the arrays
        int blocks = nums.length / k;

        // we store both the start and the end of each block (for loop style: 
        // the first element is the zero start, the second element is the end, last index +1)
        int start = 0;
        for(int i = 1; i <= blocks; i++){
            blockList.add(new Integer[]{start, start+k});
            start = start + k;
        }

        return blockList;
    }

    // return an array where the at the index i we find the max until i in nums
    private static int[] buildMaxFromLeft(int[] nums, int k, LinkedList<Integer[]> blockList) {
        int[] maxUntilFromLeft = new int[nums.length];
       
        for(Integer[] block : blockList){
            maxUntilFromLeft[block[0]] = nums[block[0]];
            for(int i = block[0]+1; i < block[1]; i++)
                maxUntilFromLeft[i] = Math.max(nums[i], maxUntilFromLeft[i-1]);
        }

        if(nums.length % k != 0){
            maxUntilFromLeft[blockList.getLast()[1]] = nums[blockList.getLast()[1]];
            for(int i = blockList.getLast()[1]+1; i < nums.length; i++)
                maxUntilFromLeft[i] = Math.max(nums[i], maxUntilFromLeft[i-1]);
            
        }

        return maxUntilFromLeft;
    }

    private static int[] buildMaxFromRight(int[] nums, int k, LinkedList<Integer[]> blockList) {
        int[] maxUntilFromRight = new int[nums.length];

        if(nums.length % k != 0){
            maxUntilFromRight[nums.length-1] = nums[nums.length-1];
            for(int i = nums.length-2; i >= blockList.getLast()[1]; i--)
                maxUntilFromRight[i] = Math.max(nums[i], maxUntilFromRight[i+1]);
        }

        for(Integer[] block : blockList){
            maxUntilFromRight[block[1]-1] = nums[block[1]-1];
            for(int i = block[1]-2; i >= block[0]; i--)
                maxUntilFromRight[i] = Math.max(nums[i], maxUntilFromRight[i+1]);
        }

        return maxUntilFromRight;
    }
}
