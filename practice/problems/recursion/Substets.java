package problems.recursion;
import java.util.ArrayList;
import java.util.List;
/*
 * > PROBLEM 78 (medium): Substers
 *   Given an integer array "nums" of unique elements, return 
 *   all possible subsets (the power set). 
 * 
 *   The solution must not contain duplicate substets. Return the 
 *   solution in any order.
 * 
 * > SOLUTION: 
 *   Classic backtrack scheme
 */
public class Substets {
    public static void main(String[] args) {
        List<List<Integer>> result = solution(new int[]{1,2,3});
        System.out.println(result.toString());
    }

    public static List<List<Integer>> solution(int[] nums){
        if(nums==null || nums.length==0) 
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    private static void backtrack(
        int[] nums, 
        int currElemIndex, 
        List<List<Integer>> result, 
        List<Integer> currentSet
    ){
        if(currElemIndex >= nums.length){
            result.add(new ArrayList<>(currentSet));
            return;
        }

        currentSet.add(nums[currElemIndex]);
        backtrack(nums, currElemIndex+1, result, currentSet);
        currentSet.remove(currentSet.size()-1);
        backtrack(nums, currElemIndex+1, result, currentSet);
    }
}