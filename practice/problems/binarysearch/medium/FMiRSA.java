package problems.binarysearch.medium;
/*
 * > PROBLEM 153 (medium) Find Minimum in Rotated Sorted Array 
 *   Suppose an array of length n sorted in ascending order is rotated between 1 
 *   and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *   [4,5,6,7,0,1,2] if it was rotated 4 times or [0,1,2,4,5,6,7] if it was 
 *   rotated 7 times.
 * 
 *   Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
 *   in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 *   Given the sorted rotated array nums of unique elements, return the 
 *   minimum element of this array.
 *   You must write an algorithm that runs in O(log n) time.
 * 
 * > SOLUTION: 
 *   comments in the code.
 *   Insight: in a sorted array for each i is true that 
 *        array[i-1] <= array[i] <= array[i+1]
 *   
 *   > for last and first element its true a single sided equation obv
 * 
 *   It the previous disequation is not respected, aka there is an i for which 
 *   nums[i] > nums[i+1] or nums[i] < nums[i-1] then it is here that the rotation 
 *   "has happened"!
 *   The sorted portions of the array are still sorted, with the rotaiton the array 
 *   was basically tramutated in a giustapposition of two sorted array: 
 *      eg: [1,2,3,4,5], k = 3
 *          - rotated array = [3,4,5,1,2]
 *          - which is equal to the concatenation of two sorted array: [3,4,5] and [1,2]
 *   
 *   This means that there is only one i for which that disequation is not respected, the 
 *   index "in between" the last element of the 1st subarray and the first element of
 *   the 2nd array
 */
public class FMiRSA {
    public static void main(String[] args) {
        int[] input1 = {3,4,5,1,2};
        assert(solution(input1) == 1);

        int[] input2 = {4,5,6,7,0,1,2};
        assert(solution(input2) == 0);

        int[] input3 = {11,13,15,17};
        assert(solution(input3) == 11);
    }

    public static int solution(int[] nums){
        if(nums.length == 1)
            return nums[0];

        int start = 0; 
        int end = nums.length-1;

        /*
            in this case there is no rotation or k = nums.length: 
            the array was sorted, if a rotation would happen than at 
            the first position surely will be a bigger number than 
            in the last position
              - eg: 1, 2, 3, 4
                - rotate 1: 4, 2, 3, 1
                - rotate 2: 3, 4, 1, 2
                - rotate 3: 2, 3, 4, 1
        */
        if(nums[end] > nums[start])
            return nums[start];

        while(end >= start){
            int mid = start + (end - start) / 2;

            // if the mid element is greater than the next one than 
            // the mid+1 element is the minimum: the array was sorted!
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];

            // if the mid element is smaller than its previous element
            // than the mid element is the smallest element
            if(nums[mid-1] > nums[mid])
                return nums[mid];

            // if the mid element is greater than the 0th element this
            // means the least value is still somewhere to the right as 
            // we are still dealing with greater elements than nums[0]
            if(nums[mid] > nums[0])
                start = mid+1;
            else
                end = mid -1;
        }
        return 1; 
    }
}
