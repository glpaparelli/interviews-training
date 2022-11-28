import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/*
 * This is a cheat sheet of all the "tricks", goto and best practice that 
 * I learned while solving the problems. This class is never used in the actual 
 * solutions since copy&paste into leetcode would not work
 */
public class Utils {
    //tricky checks
    public static void main(String[] args) { 
    }   

    /**
     * Remove all non-alphanumeric chars from a string s
     * @param s the input String s
     * @return The string s without the non-alphanumeric characters
     */
    public static String removeNonAlphanumericChars(String s){
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    /**
     * Convert an int array to a list of integer
     * @param array
     * @return
     */
    public static List<Integer> intArrayToListOfInteger(int[] array){
        return Arrays.stream(array).boxed().toList();
    }

    public static Integer[] intArrayToIntegerArray(int[] array){
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    public static int[] listOfIntegerToIntArray(List<Integer> list){
        return list.stream().mapToInt(i->i).toArray();
    }

    public static Integer[] listOfIntegerToIntegerArray(List<Integer> list){
        return list.stream().toArray(Integer[]::new);
    }

    /**
     * Check if a string s is palindrome
     * @param s the input String s
     * @return true if s is palindrome, false otherwise
     */
    public static boolean isPalindrome(String s){
        for(int i = 0, j = s.length()-1; i <= j; i++, j--)
            if(s.charAt(i) != s.charAt(j))
                return false;

        return true;
    }

    /**
     * Return true if all the elements in an array are equal to a target number
     * @param array the array of which we check if all the elements are equal to target
     * @param target the target element that every element of the array have to match
     * @return true if every element of the array is equal to target, false otherwise
     */
    public static boolean allMembersEqualTo(int[] array, int target){
        return Arrays.stream(array).allMatch(e -> e == target);
    }

    /**
     * Fill a map character c of s -> how many time c appear in s
     * @param s string of which we want the occurrence of the chars
     */
    public static void fillMapOccourrence(Map<Character, Integer> map, String s){
        for(int i = 0; i < s.length(); i++)
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v+1);
    }

    public static void smartFillMapOccourrence(Map<Character, Integer> map, String s){
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) +1);
    }

    /*
     * How to use an array as a map to store the frequency of letters in a given string
     */
    public static void arrayAsCharDictionary(String s){
        // assume s is all uppercase
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        /*
            the char has an int value: subtracting 'A' gives us the corresponding 
            in the array: is s[i] == A then s[i] - 'A' = 0. 
            freq has the length of the alphabet: each position represent a letter, 
            where A ofc is the first letter, hence at postion 0. 
            if s[i] == B than s[i] - 'A' == 1, because the letters are sorted in their 
            int value, and 1 is the second position of freq, as B is the second 
            letter in the alphabet, ...
        */
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'A']++;
    }

    /*
     * How to compute the longest string among three strings in constant time. 
     * This is better than the "if" method, because the if are exponential to 
     * the number of strings
     */
    public static String longestString(String s1, String s2, String s3){
        String longest = s1;
        if(s2.length() > longest.length())
            longest = s2;
        if(s3.length() > longest.length())
            longest = s3;

        return longest;
    }

    /*
     * How to compute the max element from the values of a map
     */
    public static Integer getMaxValueFromMap(Map<Character, Integer> map){
        return map.values().stream().max((x, y) -> Integer.compare(x, y)).get();
    }

    /*
     * How to sort a (collection) list of integers by the i-th component of the arrays
     */
    public static void sortListOfArraysByNthComponent(List<Integer[]> list, int index){
        Collections.sort(list, (e1, e2) -> Integer.compare(e1[index], e2[index]));
    }
}
