package problems.string;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 3 (medium): Longest String Without Repeating
 *   Given a string "s", find the length of the longest substring 
 *   without repeating characters
 * 
 * > SOLUTION: 
 *   We use the sliding window technique to retrieve the smallest substring
 *   without repeating. 
 *   The window [i, j] starts of size 0 (i == j == 0). We use j to go through
 *   the chars of s: if we have never seen the char s[j] then we put it in the map
 *   with j as its value. Never seen j: it means that with s[j] the current substring
 *   has grown: we get the max between the old max length and the current window. 
 * 
 *   Otherwise: if s[j] is already in the map it means that we already seen s[j],
 *   considering s[j] the window do not represent anymore a substring without 
 *   repeating chars (because of s[j]). 
 *   In this case we update i (the left end of the window) to the max between 
 *   its current value and the index of s[j] in the map +1. 
 *   In this way the left side of the window has slided. 
 *   We update the value of s[j] in the map with the current index j, 
 *   we check if the new window [i, j] is longer than the old one and we loop.
 */
public class LSwC {
    public static void main(String[] args) {
        assert(solution("abcabcbb") == 3);
        assert(solution("bbbbb") == 1);
        assert(solution("pwwkew") == 3);
    }

    public static int solution(String s){
        if(s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int length = 0; 

        for(int i = 0, j = 0; j < s.length(); j++){
            // if map contains s[j] than we have a repeating char (s[j])
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)) + 1);

            map.put(s.charAt(j), j);
            length = Math.max(length, j-i+1);
        }
        return length; 
    }
}
