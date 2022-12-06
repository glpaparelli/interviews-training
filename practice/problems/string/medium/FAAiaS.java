package problems.string.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * > PROBLEM 438 (medium): Find All Anagrams in a String
 *   Given two strings "s" and "p", return an array of all the start 
 *   indicies of p's anagrams in s. You may return the answer in any order.
 * 
 *   An Anagram is a word or phrase formed by rearranging the letters of a 
 *   different word or phrase, typically using all the original letters exactly once.
 * 
 * > SOLUTION: 
 *   Classic sliding window solution. The first window of s is from zero to 
 *   p.length()-1. 
 *   For each char in the window and for each char in w we store how many times 
 *   that char appear in p and in the window w. 
 *   If the char occurrences of the window and of p are equals than the window 
 *   is an anagram of p in s and we store the start of the window. 
 *   We let slide the window by one, removing one occurrence of the old start 
 *   and adding one occurence of the new last char of the window, then we check again
 *   if the window is an anagram and we loop.
 */
public class FAAiaS {
    public static void main(String[] args) {
        assert(solution("cbaebabacd", "abc").equals(Arrays.asList(new int[]{0,6})));
        assert(solution("abab", "ab").equals(Arrays.asList(new int[]{0,1,2})));
    }
    
    public static List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;

        // for each char how many times it appear in p
        int pCharCount[] = new int[26];
        //for each char how many times it appear in the window 
        int wCharCount[] = new int[26];

        //first window
        int start = 0;
        int end = p.length() -1;

        //count both the occurrences of the 
        //chars in s and the chars in the window
        for(int i = start; i <= end; i++){
            pCharCount[s.charAt(i) - 'a']++;
            wCharCount[p.charAt(i) - 'a']++;
        }

        //if every char in the window occours as much as it appears in the 
        //string p than the window is an anagram of p
        if(Arrays.equals(pCharCount, wCharCount))
            result.add(start);

        while(end < s.length()-1){
            //decrese of one the occourrence of the first char of the window
            //(that char will appear one time less because it will be left out
            //by the slide of the window)
            pCharCount[s.charAt(start) - 'a']--;
            
            //slide the window of one position to the right
            start++; end++;

            //increase of one the occourrence of the new end of the window 
            //that has been added by the sliding
            pCharCount[s.charAt(end) - 'a']++;
            
            if(Arrays.equals(pCharCount,wCharCount))
                result.add(start);
        }
        return result;  
    }
}
