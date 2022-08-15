package problems.string;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 409 (easy): Longest Palindrome
 *   Given a string "s" which consists of lowercase or uppercase letters, 
 *   return the length of the longest palindrome that can be built with 
 *   those letters.
 *  
 *   Letters are case sensitive, for example "aA" is not considered a 
 *   palindrome. 
 * 
 * > SOLUTION: 
 *   A palindrome is a string in which every character has a mirror partner, 
 *   plus maybe an unique center (that can be of the same letter in odd occurrence)
 *      - eg: 
 *          - AAAAAA: every char has a partner: s[0] = A -> s[5] = A, ...
 *          - ABCDKKKDCBA: the first four chars have a partner, plus we have 
 *            an unique center of K (that appear an odd number of times (3))
 *   This means that a palindrome has every chars that appear an even number of 
 *   times, plus possibly a character of odd occurrence as center 
 *      - all the odd appearing chars that are not the center have to be used
 *        in an even manner!
 *   
 *   To build the longest palindrome we simply go through the string: for every char
 *   we store the number of times it appear. 
 *   Then, if a char appear an even number of times than that char can be used. 
 *   If a char appear an odd number of times and it is the most frequent char among
 *   those that appear oddly then we use as center, otherwise we use it an even number
 *   of times (such every time it would have a partner)
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        assert(solution("abccccdd") == 7);
        assert(solution("a") == 1);
    }

    public static int solution(String s){
        if(s.length() == 0 | s == null)
            return 0;

        Map<Character, Integer> map = new HashMap<>(); 

        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        int evenChars = 0;
        //Most Frequent Odd Char Counter
        int mfocc = 0;

        for(char c : map.keySet()){
            if(map.get(c) % 2 == 0)
                // this char appear an even number of times: it always has a partner, 
                // hence we can use it every time to build the longest palindrome
                evenChars = evenChars + map.get(c);

            else{ 
                // c appear an odd number of times

                // if c appear more than the current mfoc
                // the current mfoc is no longer the mfoc, hence it can't be used 
                // as center: we can only used it an even number of times
                if(map.get(c) > mfocc){
                    if(mfocc != 0)
                        evenChars = evenChars + mfocc-1;
                    
                    mfocc = map.get(c);
                }else
                    // c appear an odd number of times but it is not the mfoc
                    // we can use it only an even number of times
                    evenChars = evenChars + map.get(c)-1;
            }
        }
        // the longest palindrome is long as the sum of the even chars (chars with a partner)
        // and the most frequent odd char used as center
        return evenChars + mfocc;
    }
}
