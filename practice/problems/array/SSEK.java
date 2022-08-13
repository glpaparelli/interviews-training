package problems.array;

import java.util.HashMap;
import java.util.Map;
/*
    > problem: Subarray Sum Equals 

    //TODO
*/
public class SSEK {
    public static int solution(int[] nums, int k){
        int subarrayCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sumStartToI = 0;
        
        for(int i = 0; i < nums.length; i++){
            sumStartToI = sumStartToI + nums[i];
            //if the map contain a subarray from 0 to some element 
            //that has as sum sumStartToI - k it means that 
            //the subarray from sumToStartToI to i has sum = k!
            if(map.containsKey(sumStartToI - k))
                subarrayCount = subarrayCount + map.get(sumStartToI - k);
            
            //if from the start till now the sum is k 
            //then  we found a subarray of sum k
            if(sumStartToI == k) 
                subarrayCount++;
            
            if(map.containsKey(sumStartToI))
                map.put(sumStartToI, map.get(sumStartToI)+1);
            else
                map.put(sumStartToI, 1);
        }
        
       return subarrayCount; 
    }
}
