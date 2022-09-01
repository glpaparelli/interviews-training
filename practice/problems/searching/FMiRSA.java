package problems.searching;
/*
 * > PROBLEM 153 (medium) Find Minimum in Rotated Sorted Array 
 *   TODO
 */
public class FMiRSA {
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
            // the mid+1 element is the minum: the array was sorted!
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];

            // if the mid element is lesser than its previous element
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
