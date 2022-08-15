package problems.array;
import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*
 * > PROBLEM 977 (easy): Square of a Sorted Array
 *   Given an array "nums" sorted in non-decreasing order, return
 *   an array of the squares of each number sorted in non-decreasing order
 * 
 * > SOLUTION: 
 *   Split the array in positives and negatives, the smaller a negative number
 *   is the bigger is squared value will be, so to mantain the non-decreasing
 *   order we reverse the list of negatives.
 *   Then simply square each number of the negatives and the positives 
 *   and merge the two lists, using the merge function from merge sort
 * 
 * > NOTE: 
 *   there are some possible optimization space-wise. 
 *   For example we could split the array nums using indexs, without 
 *   creating two lists
 */
public class SoaSA {
    public static void main(String[] args) {
        assertArrayEquals(solution(new int[]{-4,-1,0,3,10}), new int[]{0,1,9,16,100});
        assertArrayEquals(solution(new int[]{-7,-3,2,3,11}), new int[]{4,9,9,49,121});
    }

    public static int[] solution(int[] nums){
        // split the array in two: the negatives and positives numbers
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for(int num : nums)
            if(num < 0)
                negatives.add(num);
            else
                positives.add(num);

        // reverse the negatives so the order will be mantained
        Collections.reverse(negatives);

        // square every element of the lists
        negatives = negatives.stream().map(x -> (int) Math.pow(x, 2)).collect(Collectors.toList());
        positives = positives.stream().map(x -> (int) Math.pow(x, 2)).collect(Collectors.toList());

        // return the merged array
        return merge(nums, negatives, positives);        
    }

    private static int[] merge(int[] nums, List<Integer> negatives, List<Integer> positives) {
        int n = 0, p = 0, current = 0;
        while(n < negatives.size() && p < positives.size()){
            if(negatives.get(n) < positives.get(p))
                nums[current++] = negatives.get(n++);
            else
                nums[current++] = positives.get(p++);
        }

        while(n < negatives.size())
            nums[current++] = negatives.get(n++);
        
        while(p < positives.size())
            nums[current++] = positives.get(p++);

        return nums;
    }
}
