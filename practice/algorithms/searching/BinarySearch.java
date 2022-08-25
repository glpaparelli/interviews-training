package algorithms.searching;
/*
 * > PROBLEM 704 (easy): Binary Search
 *   //TODO
 */
public class BinarySearch {
    public static void main(String[] args) {
        int x = recSolution(new int[]{5}, 5, 0, 0);
        System.out.println(x);
    }

    public static int itSolution(int[] nums, int target){
        int start = 0; 
        int end = nums.length -1; 
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target)
                end = mid - 1;

            if(nums[mid] < target)
                start = mid + 1;
        }

        return -1;
    }

    public static int recSolution(int[] nums, int target, int start, int end){
        if(start >= end){
            if(nums[start] == target)
                return start;
            return -1; 
        }

        int mid = (start + end) / 2;

        if(nums[mid] == target)
            return mid; 

        if(nums[mid] > target)
            return recSolution(nums, target, start, mid-1);

        if(nums[mid] < target)
            return recSolution(nums, target, mid+1, end);

        return -1;
    }
}
