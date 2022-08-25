package problems.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * > PROBLEM 46 (medium): Permutations 
 *   Given an array "nums" of distinct integers, return all the
 *   possible permutations. 
 *   You can return the answer in any order.
 * 
 * > SOLUTION:
 *   Classic backtrack scheme: we swap elements to avoid to repeat 
 *   the permutation, then we swap back for the next permutations
 */
public class Permutations {
    
    public static List<List<Integer>> solution(int[] nums){
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        if(nums.length == 1)
            return List.of(List.of(Arrays.stream(nums).boxed().toArray(Integer[] :: new)));

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    /**
     * @param nums array of elements of which we want the permutations
     * @param start the index of the current element
     * @param result the list of permutations
     * @param current the current permutation
     */
    private static void backtrack(
        int[] nums, 
        int start, 
        List<List<Integer>> result, 
        List<Integer> current) 
    {
        if (start == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int end = start; end < nums.length; end++) {
			current.add(nums[end]);
            swap(nums, start, end);
			backtrack(nums, start+1, result, current);
			current.remove(current.size() -1);
            swap(nums, start, end);
		}
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
