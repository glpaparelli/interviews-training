package easy;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 217 (easy): Contains Duplicate
 *   Given an array "nums" return true if any value appears at 
 *   least twice in the array and return false if every element
 *   is distinct
 * 
 * > SOLUTION: 
 *   We use a set (HashSet): for each element of the array we check 
 *   if the element is in the set, if so we return true, otherwise 
 *   we insert in the set and loop. 
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        assertTrue(solution(new int[]{1,2,3,1}));
        assertFalse(solution(new int[]{1,2,3,4}));
        assertTrue(solution(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums)
            if(set.contains(num))
                return true;
            else
                set.add(num);

        return false;
    }
}
