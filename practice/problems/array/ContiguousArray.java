package problems.array;

import java.util.HashMap;
import java.util.Map;
/*
    > problem: Contiguous Array
    Given a binary array "nums" return the maximum length of a 
    contiguous subarray with an equal number of 0 and 1.
    
    > idea: to achieve the best possible solution we have to use 
    a map, a variable counter and a variable to store the current 
    max length of a balanced subarray (balanced aka #0 == #1). 
        
    Whenever we find a 0 in the array we decrease the counter and when 
    we find a 1 we increase the counter. Both counter and lenght start
    from 0.

    If counter is = n > 0 then in the subarray we have n extra 1s, 
    if counter is = 0 then the subarray is balanced and if 
    counter is n < 0 then in the subarray we have n extra 0s

    Let's see an example: 

                index   =  [0,  1,  2,  3,  4,  5,  6,  7]
                nums    =  [1,  0,  0,  1,  1,  0,  0,  1]
                counter =  [1,  0, -1,  0,  1,  0, -1,  0]
    
    When at the index i the counter is 0 then the subarray [0, i-1] is 
    balanced. But we also notice another property. 
    The subarray [0, 2] = [1,0,0] has counter = -1, since it has an extra zero. 
    The subarray [0, 6] = [1,0,0,1,1,0,0] also has counter = -1, because it has
    an extra zero!
    We notice that if we subtract from the subarray [0, 6] the subarray [0,2] we 
    obtain the subarray [3, 6] = [1,1,0,0], which is balanced!
        - this is logical: from a subarray with an extra zero we subtracted a 
          sub-subarray with an extra zero -> the resultant (sub-)subarray do not have
          the extra zero.
    
    This means that we don't have only to check when counter is zero, but also 
    when counter reach a value that it has already had before, because the sub-subarray
    that goes from the right adjacent index of the subarray that has the same counter to i
    is balanced!
    - to store when (aka at which index) the counter had that value before we use 
      a map counter -> index
*/
public class ContiguousArray {
    //TODO MAIN
    public static int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int lenght = 0, counter = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                counter--;
            else
                counter++;

            //counter = 0 => [0, i] is balanced, hence we increase the length!
            if(counter == 0) 
                lenght = i+1;
            //we already had that counter? the current length is greater than the length 
            //of the balanced sub-subarray obtained by [0, i] - [0, old counter index]?
            else if(map.containsKey(counter))
                lenght = Math.max(lenght, i-map.get(counter));
            //counter never had this value before, we store the corresponding index in 
            //the map
            else
                map.put(counter, i);
        }
        return lenght;
    }

}
