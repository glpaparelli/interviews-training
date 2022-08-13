package problems.string;

import java.util.HashMap;
import java.util.Map;
//TODO
/*
    > problem: Longest Substring without Repeating 
*/
public class LSwC {
    
    public static int dumbSolution(String s){
        if(s.isEmpty())
            return 1;
        if(s.isBlank())
            return 1; 

        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int currentLength = 0;
        int index = 0;

        while(index < s.length()){
            if(!map.containsKey(s.charAt(index))){
                currentLength++;
                map.put(s.charAt(index), index);
                index++;
            }else{
                length = Math.max(length, currentLength);
                currentLength = 0;
                index = map.get(s.charAt(index)) + 1;
                map.clear();
            }
        }
        //case no repeating never go in else
        return Math.max(length, currentLength);
    }

    public static int solution(String s){
        if(s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int length = 0; 

        for(int i = 0, j = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            map.put(s.charAt(j), j);
            
            length = Math.max(length, j-i+1);
        }

        return length; 
    }

}
