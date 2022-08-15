package problems.string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * > PROBLEM 49 (medium): Group Anagram 
 *   Given an array of string "strs", group the anagrams together.
 *   You can return the answer in any order. 
 * 
 *   An anagram is a word or phrase formed by rearranging the letters
 *   of a different word or pharese, typically using all the original
 *   letters exactly once
 * 
 * > SOLUTION: 
 *   Two strings are anagram if every char in them appear the same number
 *   of times. 
 *   For every string we build an array that maps to every letter of the 
 *   alphabet how many times that letter appear in the string. 
 *   Then we convert the array (the number of occurrences) in a string that
 *   we use as key to group strings with the same occurrences of letters, 
 *   to group anagrams.
 *   Finally we return a list of values of the map, which is a list 
 *   of lists of anagrams
 */
public class GroupAnagram {
    public static void main(String[] args) {
        String[] input1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output1 = solution(input1);
        List<List<String>> expected1 = new ArrayList<>();
        expected1.addAll(
            List.of(
                List.of("bat"), 
                List.of("nat", "tan"), 
                List.of("ate","eat","tea")
            )
        );
        assert(output1.equals(expected1));

        String[] input2 = new String[]{""};
        List<List<String>> output2 = solution(input2);
        List<List<String>> expected2 = new ArrayList<>();
        assert(output2.equals(expected2));

        String[] input3 = new String[]{"a"};
        List<List<String>> output3 = solution(input3);
        List<List<String>> expected3 = new ArrayList<>();
        expected3.add(List.of("a"));
        assert(output3.equals(expected3));
    }

    public static List<List<String>> solution(String[] strs){
        if(strs == null || strs.length == 0) 
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            // trick: we use a char array: when we increment we will get random chars
            // but the point is that this will be equal among strings that are anagrams
            char[] sDict = new char[26];

            for(char c : s.toCharArray()) 
                sDict[c - 'a']++;

            map.putIfAbsent(String.valueOf(sDict), new ArrayList<>());
            map.get(String.valueOf(sDict)).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
