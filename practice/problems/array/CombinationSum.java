package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    > problem: Combination Sum
    Given ana rray of distinct integers "candidates" and a target 
    integer "target", return a list of all unique combinations of 
    candidates where the choosen numbers sum to target. You may 
    return the combinations in any order. 

    The same number may be choosen from candidates an unlimited 
    number of times. Two combinations are unique if the frequency 
    of at least one of the chosen number is different.

    It is guaranteed that the number of unique combinations that sum
    up to target is less than 150 combinations for the given input

    e.g: candidates = [2, 3, 6, 7], target = 7
        - output = [[2,2,3], [7]]

    > idea: Use recursion to build a conceptual tree where as root 
    we have the pair <array, target>. The first child will be 
    the pair <array, target - a[0]>, the second child will be 
    <array starting from a[1], target - a[1]> and so on
    - every node will have n childer
    - "shifting" the starting point of the array we make sure that 
      we do not analyze the same combination in a different order
        - the brother i+1 start the array from the position i+1   
    Mind that to use this trick the array must be sorted, so we 
    don't loose any element   
    
    > note: The time complexity of the solution is O(N^((M/T) + 1)) where 
    N is the number of candidates, M is the smallest candidate among all
    the given integers, and T is the target. Time is exponential but this 
    is expected since the algorithm is recursive backtracking
    The space complexity is O(T/M)
*/
public class CombinationSum {
    
    public static void main(String[] args) {
        List<List<Integer>> output1 = solution(new int[]{2,3,6,7}, 7);
        assert(output1.get(0).equals(Arrays.asList(new int[]{2,2,3})));
        assert(output1.get(1).equals(Arrays.asList(new int[]{7})));

        List<List<Integer>> output2 = solution(new int[]{2,3,5}, 8);
        assert(output2.get(0).equals(Arrays.asList(new int[]{2,2,2,2})));
        assert(output2.get(1).equals(Arrays.asList(new int[]{2,3,3})));
        assert(output2.get(2).equals(Arrays.asList(new int[]{3,5})));
        
        List<List<Integer>> output3 = solution(new int[]{2}, 1);
        assert(output3.get(0).equals(Arrays.asList(new int[]{})));
    }

    public static List<List<Integer>> solution(int[] candiates, int target){
        Arrays.sort(candiates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), candiates, target, 0);
        return result;
    }

    /**
     * @param result is the list of combinations
     * @param current is the combination that we are building now
     * @param candiates is the input array
     * @param target is the current target
     * @param start is the start of the array in the current call
     */
    private static void backtrack(
        List<List<Integer>> result, 
        ArrayList<Integer> current, 
        int[] candiates, 
        int target,
        int start
    ){
        //this path (and combiantion) is useless
        if(target < 0)
            return;
        
        //this path (and combination) is a good one since it sum up to target!
        if(target == 0)
            result.add(new ArrayList<Integer>(current));
        else{
            /* if the current combination do not sum up to target then we have
            to continue the recursion and see if the next element of the 
            combination will do */
            for(int i = start; i < candiates.length; i++){
                current.add(candiates[i]);
                //start is i and not i+1 because we can resue elements!
                backtrack(result, current, candiates, target - candiates[i], i);

                /* This is tricky: we add candiates[i] to the list, then we backtrack and
                then we remove candiates[i]. If with candiates[i] the combination sum up to zero
                the call backtrack will add the current solution to the result, and
                now that last element will be useless and hence removed, so the for 
                can loop and try another "last element candiates[i]". 
                The same reasoning goes with the case where candiates[i] makes the target 
                smaller than 0 */
                current.remove(current.size() - 1);
            }
        }
    }
}
