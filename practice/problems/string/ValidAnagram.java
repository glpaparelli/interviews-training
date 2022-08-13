package problems.string;

import java.util.HashMap;
import java.util.Map;

//TODO

public class ValidAnagram {
    public static boolean solution(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        if(s1.length() != s2.length())
            return false;
        
        for(int i = 0; i < s1.length(); i++)
            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i), 1);
        
        for(int i = 0; i < s1.length(); i++)
            if(!map.containsKey(s2.charAt(i)))
                return false;
            else
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
        
        for(Integer i : map.values())
            if(i != 0)
                return false;

        return true;
    }
}
