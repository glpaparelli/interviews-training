package problems.array;

import static org.junit.Assert.assertArrayEquals;
/*
    > problem: Move Zeros
    Given an integer array "nums", move all 0's to the end of
    it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array

    > idea: we count the number of zeroes. if an element is zero we increment the
    counter, otherwise we put the current element(which is not zero) in 
    current index - number of zeroes. 
    At the end we set as zero the last number of zeroes element of the array. 
    Basically we throw the non zeroes element at the leftmost of the array. 
        - e.g: nums = [1, 3, 0, 1, 0]
            - i = 0, zeroes = 0, nums[i] != 0
                - nums[i - zeroes] = nums[0] = nums[i] = nums[0] = 1
            - i = 1, zeroes = 0, nums[i] != 0
                - nums[i - zeroes] = nums[1] = nums[i] = nums[1] = 3
            - i = 2, zeroes = 0, nums[i] == 0
                - zeroes = zeroes + 1
            - i = 3, zeroes = 1, nums[i] != 0
                - nums[i - zeroes] = nums[2] = nums[i] = nums[3] = 1
            - i = 4, zeroes = 1, nums[i] == 0
                - zeroes = zeroes + 1
            > now nums = [1, 3, 1, 1, 0], zeroes = 2
            > for i = nums.length - zeroes = 5 - 2 = 3 to i < nums.length 
                - i = 3, nums[i] = 0
                - i = 4, nums[i] = 0
            > finally nums = [1, 3, 1, 0, 0]
*/
public class MoveZeroes {
    public static void main(String[] args) {
        int[] test1 = new int[]{0,1,0,3,12};
        int[] test2 = new int[]{0};
        solution(test1);
        solution(test2);
        assertArrayEquals(test1, new int[]{1,3,12,0,0});
        assertArrayEquals(test2, new int[]{0});
    }

    public static void solution(int[] nums){
        int zeroes = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeroes++;
            else
                nums[i - zeroes] = nums[i];
        }

        for(int i = nums.length - zeroes; i < nums.length; i++)
            nums[i] = 0;

    }
}
