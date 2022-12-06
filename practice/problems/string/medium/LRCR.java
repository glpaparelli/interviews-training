package problems.string.medium;
import java.util.Arrays;
/*
 * > PROBLEM 424 (medium): Longest Repeating Character Replacement
 *   You are given a string "s" and an integer "k". You can choose 
 *   any character of the string and change it to any other uppercase
 *   english character. You can perform this operation at most k times. 
 * 
 *   Return the length of the longest substring containing the same 
 *   letter you can get after performing the above operations
 * 
 * > SOLUTION: 
 *   We use a sliding window sulution and a map to keep track of how 
 *   many times a character appear in the window. 
 *   The window start of size zero and it represents a substring of 
 *   repeating chars. 
 *   When we update the window it means that we can't build a repeating
 *   char substring with only k substitutions
 */
public class LRCR {
    public static void main(String[] args) {
        assert(solution("ABAB", 2) == 4);
        assert(solution("AABABBA", 1) == 4);
    }

    public static int solution(String s, int k){
        if(s == null || s.length() == 0)
            return 0;

        int max = 0; // result

        // char frequence map: sDict[char] -> #occurrence of char in w
        int[] sDict = new int[26];
        Arrays.fill(sDict, 0);
        // mfc = most frequent character

        int mfc = 0;
        // the window start at size zero (left == right == zero)
        int left = 0;
        for(int right = left; right < s.length(); right++){
            sDict[s.charAt(right) - 'A']++;
            mfc = Math.max(mfc, sDict[s.charAt(right) - 'A']);
            
            /*
                we want the longest substring with the same char
                the best char to use is the most frequent one and 
                change the other chars to mfc. 
                if we have to change more than k times than 
                we move the left side of the window, since the window
                as it is is no longer useful: the window represent 
                the current substring of the same char
            */
            int lettersToChange = (right - left + 1) - mfc;
            if(lettersToChange > k){
                sDict[s.charAt(left) - 'A']--;
                left++;
            }
            // we update the max: is longer the old window or the current one?
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
