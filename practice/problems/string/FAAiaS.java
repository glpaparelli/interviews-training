package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//TODO
/*
    > problem: Find All Anagrams in a String
*/

public class FAAiaS {

    public static void main(String[] args) {
        
    }
    
    //#region my dumb solution: may work but it is too tricky
    public static List<Integer> myDumbSolution(String s, String p){
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer[]> pDict = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            if(pDict.containsKey(p.charAt(i))){
                Integer[] value = pDict.get(p.charAt(i));
                value[0]++;
                value[1] = value[0];
            }
            else
                pDict.put(p.charAt(i), new Integer[]{1,1});
        }
        
        int i = 0;
        while(i <= s.length() - p.length()){
            int j = i; 
            boolean failed = false;
            while(j - i < p.length()){
                if(pDict.containsKey(s.charAt(j))){
                    Integer[] value = pDict.get(s.charAt(j));
                    value[0]--;
                    j++;
                }else{
                    //abs needed eg: s = aa, p = bb
                    //pDict dont contain b, i = 0 + j = 0 - 1 = -1
                    //s.charAt(-1) => exception
                    i = j+1;
                    failed = true;
                    break;
                }
            }

            if(!failed){ 
                if(checkAnagram(pDict))
                    indexes.add(i);
                i++;
            }else
                checkAnagram(pDict);
        }
        return indexes;
    }

    //also reset the right counter
    private static boolean checkAnagram(Map<Character, Integer[]> pDict){
        boolean check = true;
        for(Character c : pDict.keySet()){
            Integer[] value = pDict.get(c);
            if(value[0] != 0)
                check = false;
            value[0] = value[1];
        }
        return check;
    }
    //#endregion
    //#region a dumb solution: works but too slow for leetcode
    public static List<Integer> sndDumbSolution(String s, String p){
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pCharOccurrences = createMap(p);
        Map<Character, Integer> subSCharOccurrences = null;

        for(int i = 0; i < s.length() - p.length()+1; i++){
            subSCharOccurrences = createMap(s.substring(i, i+p.length()));
            if(pCharOccurrences.equals(subSCharOccurrences))
                result.add(i);
        }

        return result;
    }

    private static Map<Character, Integer> createMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray())
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        return map;
    }
    //#endregion
    
    
    //#region solution
    public List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;

        //for each char how many times it appear in p
        int pCharCount[] = new int[26];
        //for each car how many times it appear in the window 
        int wCharCount[] = new int[26];

        //first window
        int start = 0;
        int end = p.length() -1;

        //count both the occurrences of the 
        //chars in s and the chars in the window
        for(int i = start; i <= end; i++){
            //'a' has a certain int value, 'b' = 'a'+1, 'c' = 'b' + 1 = 'a' + 2 ...
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
    //#endregion solution
}
