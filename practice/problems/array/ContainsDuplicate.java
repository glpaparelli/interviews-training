package problems.array;

import java.util.HashSet;
import java.util.Set;
/*
    > problem: Contains Duplicate
    Given an array "nums" return true if any value appears at
    least twice in the array and return false if every element
    is distinct

    > idea: to minimize the complexity in time it is enough to
    exploit a HashSet (backed as HashMap). 
    For each element i of the array we check if the element is already
    in the set, if not we insert it, otherwise we return true
        
*/
public class ContainsDuplicate {
    public static void main(String[] args) {
        assert(solution(new int[]{1,2,3,1}));
        assert(!solution(new int[]{1,2,3,4}));
        assert(solution(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++)
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        
        return false;
    }
}
