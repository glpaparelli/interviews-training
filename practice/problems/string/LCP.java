package problems.string;
/*
 * > PROBLEM 14 (easy): Longest Common Prefix
 *   Write a function to find the longest common prefix string amongst
 *   an array of strings. 
 *   If there is no common prefix, return an empty string ""
 * 
 * > SOLUTION: 
 *   The longest common prefix is, at most, long as the shortest word in 
 *   the array of strings. 
 *   Once found the shortest string we start checking if the char 
 *   i (starting from zero) of the shortest string is also shared 
 *   by all the other strings. If so all the strings have as current 
 *   prefix the char shortestString[i], hence the prefixLength is increased. 
 *   As soon as we wound a character shortestString[i] not shared by all the other 
 *   strings we return the substring shortestString[0, prefixLength]
 */
public class LCP {
    public static void main(String[] args) {
        assert(solution(new String[]{"flower", "flow", "flight"}).equals("fl"));
        assert(solution(new String[]{"dog", "racecar", "car"}).equals(""));
    }

    public static String solution(String[] strs){
        if(strs.length == 0 || strs == null)
            return "";

        String shortestString = strs[0];
        for(String s : strs)
            if(s.length() < shortestString.length())
                shortestString = s;
        
        int prefixLength = 0;

        /*
            for every char of the shortest string we check if that 
            char is shared among every word in word. If so that char 
            is part of the common longest prefix
            as soon we find a char of the shortest string that is not 
            shared amongst every string we return;
        */
        for(int i = 0; i < shortestString.length(); i++){
            for(String s : strs)
                if(s.charAt(i) != shortestString.charAt(i))
                    return shortestString.substring(0, prefixLength);
                
            prefixLength++;
        }
        return shortestString.substring(0, prefixLength);
    }
}