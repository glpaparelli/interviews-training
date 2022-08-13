package problems.string;

import java.util.HashMap;
import java.util.Map;

//TODO

public class LongestPalindrome {
    public static int solution(String s){
        Map<Character, Integer> map = new HashMap<>(); 
        for(int i = 0; i < s.length(); i++)
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i), 1);
        
        int evenChars = 0;
        int mostFrequentOddChar = 0;

        for(char c : map.keySet()){
            if(map.get(c)%2 == 0)
                evenChars = evenChars + map.get(c);
            else{
                if(map.get(c) > mostFrequentOddChar){
                    if(mostFrequentOddChar != 0)
                        evenChars = evenChars + mostFrequentOddChar-1;
                    mostFrequentOddChar = map.get(c);
                }else
                    evenChars = evenChars + map.get(c)-1;
            }
        }
        return evenChars + mostFrequentOddChar;
    }
}
