package problems.array;
import static org.junit.Assert.assertArrayEquals;
/*
 * > PROBLEM 189 (medium): Rotate Array
 *   Given an array, rotate the array by k steps, where k is >= 0
 *      - e.g: nums = [1,2,3,4,5,6,7], k = 3 -> [5,6,7,1,2,3,4]
 * 
 * > SOLUTION: 
 *   We want to move the last k elements at the start of the array. 
 *   If we reverse the whole array we will get the the last k elements 
 *   at the start, but in reverse order. 
 *   At this point simply reverse the first k elements and the remaining elements
 *   to restore the original order!
 *      - eg: nums = [1,2,3,4,5,6,7], k = 3
 *          - we want the last k = 3 elements at the beginning of the array, so 
 *            we reverse the whole array -> [7,6,5,4,3,2,1]
 *          - now we reverse the first 3 elements to restore the order and we obtain 
 *            the array -> [5,6,7, 4,3,2,1]
 *          - now reverse the remaining part to restore the order: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] output1 = new int[]{1,2,3,4,5,6,7};
        solution(output1, 3);
        assertArrayEquals(output1, new int[]{5,6,7,1,2,3,4});

        int[] output2 = new int[]{-1,-100,3,99};
        solution(output2, 2);
        assertArrayEquals(output2, new int[]{3,99,-1,-100});
    }

    public static void solution(int[] nums, int k){
        if(nums == null || nums.length < 2)
            return;
        
        k = k % nums.length; //k may be bigger than the size of the array
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
