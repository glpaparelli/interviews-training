package problems.string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.Pair;
/*
 * > PROBLEM 76 (hard): Minimum Window Substring
 *   Given two strings "s" and "t" of lengths m and n respectively, return the
 *   minimum window substring of s such that every char in t (including duplicates)
 *   is included in the window. If there is no such substring, return "". 
 * 
 * > SOLUTION: 
 *   The problem asks us to return the minimum window of S which has all the chars 
 *   of the string t. 
 *   We call a window "desirable" if the window actually has all the chars of t.
 *   As in any other sliding window problem we have two pointers
 *      - left: it represent the left end (aka: the start) of the window and its job
 *        is to contract the window
 *      - right: it represent the right end (aka: the end) of the window and its job 
 *        is to expand the window
 * 
 *   We keep expanding our window until it becomes desirable. When it has become 
 *   desirable we try to contract the window and save the smallest window till now.
 * 
 *   The basic algorithm is as follow: 
 *      1) we start with two pointers left and right initially pointing at the first 
 *         element of the string
 *      2) we use the right pointer to expand the window until we get a desirable window
 *      3) once we have a window with all chars we can move the left pointer ahead one by
 *         one. If the window is still desirable we keep updating the minimum window size
 *      4) if the window is not desirable any more we repeat the step 2 onwards
 *   The above steps are repeated untill all windows have been checked. The smallest window
 *   is returned. 
 * 
 * > NOTE: we are using the micro-optimized verion of the previous algorithm, where we build
 *   a list of only the chars in s that actually appear in t with their respective indexes, 
 *   so that the search of chars is only amongst the chars that are actually useful. 
 */
public class MWS {
    public static void main(String[] args) {
        assert(solution("ADOBECODEBANC", "ABC").equals("BANC"));
        assert(solution("A", "A").equals("A"));
        assert(solution("A", "AA").equals(""));
    }

    public static String solution(String s, String t){
        if(s.length() == 0 || t.length() == 0) 
            return "";
        
        // map every char c of t with the number of times c appear in t
        Map<Character, Integer> tDict = new HashMap<Character, Integer>();
        for(char c : t.toCharArray())
            tDict.put(c, tDict.getOrDefault(c, 0)+1);

        // filter all the characters from s into a new list along with their index.
        // the filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) 
            if(tDict.containsKey(s.charAt(i))) 
                filteredS.add(new Pair<Integer, Character>(i, s.charAt(i)));
    
        //number of binds <k, v> in tDict
        int required = tDict.size();

        // result[0] = length of the substring
        // result[1] = start index of the substring
        // result[2] = end index of the substring
        int[] result = {-1,0,0};

        // map every character in the window to how many times that character appear in the window
        Map<Character, Integer> wDict = new HashMap<Character, Integer>();

        // left and right are the current ends of the window
        // formed is the number of chars in the window that appear as much as they appear in t
        int left = 0, right = 0, formed = 0;

        // look for the chars only in filteredS instead of entire s: this reduce the search
        while(right < filteredS.size()) {
            char c = filteredS.get(right).getValue();
            wDict.put(c, wDict.getOrDefault(c, 0) + 1);

            if(tDict.containsKey(c) && wDict.get(c).intValue() == tDict.get(c).intValue()) 
                formed++;
            
            // try and contract the window till the point where it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = filteredS.get(left).getValue();

                // save the smallest window until now.
                int end = filteredS.get(right).getKey();
                int start = filteredS.get(left).getKey();
                if(result[0] == -1 || end - start + 1 < result[0]) {
                    result[0] = end - start + 1;
                    result[1] = start;
                    result[2] = end;
                }

                wDict.put(c, wDict.get(c) - 1);
                if(tDict.containsKey(c) && wDict.get(c).intValue() < tDict.get(c).intValue())
                    formed--;
                
                left++;
            }
            right++;
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
