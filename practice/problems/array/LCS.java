package problems.array;

import java.util.HashSet;
import java.util.Set;

/*
    > problem: Longest Consecutive Sequence
    Given an unsorted array of integers "nums" return the length 
    of the longest consecutive elements sequence. 
    You must write an algorithm that runs in O(n) time

    > idea: we exploit the fast lookup of the set to run in O(n). 
    We take the length of elements going up, it means that if the current 
    element -1 is also in the set we skip and wait until we find it. 
    If an element is present in the set we increment the current length of the 
    sequence to 1, we update the current element to the current element +1 and look
    it up on the set, and so on. 
*/
public class LCS {
    
    //TODO MAIN
    public int solution(int[] nums){
        int maxLength = 0;
        Set<Integer> numbers = new HashSet<>();

        //add every number in the set
        for(int i : nums)
            numbers.add(i);

        //for each number in the set
        for(int num : numbers){
            //if the num-1 is in the set we skip, we'll analyze this sequence
            //later on (given the fact that a sequence num-1, num, num+1, num+2, ...)
            //is surely longer than the sequence num, num+1, num+2, ...)
            if(numbers.contains(num-1))
                continue;

            int current = num;
            int currentLength = 1;
            //while the set contain the next element we keep counting
            while(numbers.contains(current+1)){
                current++; 
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
