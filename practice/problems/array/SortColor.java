package problems.array;
import static org.junit.Assert.assertArrayEquals;
/*
 * > PROBLEM 75 (medium): Sort Color
 *   Given an array "nums" with n objects colored red, white or blue, 
 *   sort them in-place so the objects of the same color are adjacent, 
 *   with the colors in order red, white and blue. 
 * 
 *   We will use the integers 0, 1 and 2 to represen the color red, 
 *   white and blue respectively. 
 * 
 *   You must solve this problem without using the library's sort function
 * 
 * > SOLUTION: 
 *   In more than one pass the problem is trivial, simply use the strategy
 *   of the counting sort and fill the array. 
 *   The tricky part is to solve the problem with one pass. 
 *   The intuition is pretty easy: you store the index of where to put the 
 *   zeroes that starts from zero and you store the index where to put twos. 
 *   Then for each element i of the array: if the element is zero you swap with the zero 
 *   index and increment it, otherwise if the element is two you swap with the two index
 *   and decrease it, else you simply go with the next element
 */
public class SortColor {
    public static void main(String[] args) {
        assertArrayEquals(solution(new int[]{2,0,2,1,1,0}), new int[]{0,0,1,1,2,2});
        assertArrayEquals(solution(new int[]{2,0,1}), new int[]{0,1,2});
    }

    public static int[] solution(int[] nums){
        int i = 0;
        int putZeroHere = 0; 
        int putTwoHere = nums.length-1;

        while(i <= putTwoHere){
            if(nums[i] == 0){
                swap(nums, putZeroHere, i);
                putZeroHere++; i++;
            }
            else if(nums[i] == 2){
                swap(nums, putTwoHere, i);
                putTwoHere--;
            }else 
                i++;
        }
        return nums;
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}