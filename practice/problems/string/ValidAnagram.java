package problems.string;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 242 (easy): Valid Anagram
 *   Given two strings "s" and "t", return true if t is an anagram 
 *   of s, and false otherwise
 * 
 *   An anagram is a word or phrase formed by rearranging the letters 
 *   of a different word of phrase, typically using all the original 
 *   letters exactly once.
 * 
 * > SOLUTION: 
 *   We usa a map to keep track of the number of occurrences of chars
 *   in the strings. 
 *   To be anagram the string s and t have to be of the same length.
 *   To be anagram every char in s have to appear the same amount of time
 *   in t. 
 *   We iterate over the string in one pass with the index i starting from 0,
 *   the char at index i of s increase the counter, the char i of t decrease the
 *   counter. At the end if every counter is zero than the two strings are anagram
 */
public class ValidAnagram {
    public static void main(String[] args) {
        assert(solution("anagram", "nagaram"));
        assert(solution("rat", "car"));
    }

    public static boolean solution(String s, String t){
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) -1);
        }

        return map.values().stream().allMatch(x -> x == 0);
    }
}
