package problems.recursion.medium;
/*
 * > PROBLEM 31 (medium): Next Permutation
 *   A permutation of an array of integers is an arrangement 
 *   of its members into a sequence or linear order.
 *   
 *  The next permutation of an array of integers is the next
 *  lexicographically greater permutation of its integer. More
 *  formally, if all the permutations of the array are sorted in one
 *  container according to their lexicographical order, then the next
 *  permutation of that array is the permutation that follows it in
 *  the sorted container. If such arrangement is not possible, the
 *  array must be rearranged as the lowest possible order (i.e.,
 *  sorted in ascending order).
 * 
 *  Given an array of integers "nums", find the next permutation of nums.
 *  The replacement must be in place and use only constant extra memory.
 * 
 * > SOLUTION: 
 *   We notice that for any given sequence that is in descending order, no 
 *   next larger permutation is possible. 
 *   We need to find the first pair of two successive numbers a[i] and a[i-1],
 *   from the right, which satisfy a[i] > a[i−1].
 *   Now, no rearrangements to the right of a[i-1] can create a larger permutation 
 *   since that subarray consists of numbers in descending order. 
 *   Thus, we need to rearrange the numbers to the right of a[i-1] including itself.
 * 
 *   Now, what kind of rearrangement will produce the next larger number? 
 *   We want to create the permutation just larger than the current one.
 *   Therefore, we need to replace the number a[i-1] with the number which is 
 *   just larger than itself among the numbers lying to its right section, say a[j].
 * 
 *   We swap the numbers a[i-1] and a[j]. We now have the correct number at index i-1. 
 *   But still the current permutation isn't the permutation that we are looking for.
 *   We need the smallest permutation that can be formed by using the numbers only 
 *   to the right of a[i-1]. 
 *   Therefore, we need to place those numbers in ascending order to get their 
 *   smallest permutation.
 *   But, recall that while scanning the numbers from the right, 
 *   we simply kept decrementing the index until we found the pair a[i] and a[i-1]
 *   where, a[i] > a[i−1]. 
 *   Thus, all numbers to the right of a[i-1] were already sorted in descending order. 
 *   Furthermore, swapping a[i-1] and a[j] didn't change that order. 
 *   Therefore, we simply need to reverse the numbers following a[i−1] to get the 
 *   next smallest lexicographic permutation.
 */
public class NP {
    public static void main(String[] args) {
       int[] input1 = new int[]{1,2,3};
       solution(input1);
       assert(input1 == new int[]{1,3,2});

       int[] input2 = new int[]{3,2,1};
       solution(input2);
       assert(input2 == new int[]{1,2,3});

       int[] input3 = new int[]{1,1,5};
       solution(input3);
       assert(input3 == new int[]{1,5,1});
    }

    public static void solution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) 
                j--;
            
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) 
            swap(nums, i++, j--);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
