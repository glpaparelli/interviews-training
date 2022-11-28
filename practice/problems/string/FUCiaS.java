package problems.string;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM "387" (easy) : First Unique Character in a String
 *   Given a String s find the first non-repeating character in s
 *      
 * > SOLUTION: 
 *   - mapSolution: populate a map of occurrences, then for each char in s
 *     get the number of occurrences using the map and return the first one
 *     that has only 1 occurrence
 * 
 *   - streamSolution: same map but using a stream to find the first char
 *     with only one occurrence in s
 */
public class FUCiaS {
    public static void main(String[] args) {
        assertTrue(streamSolution("aabbccfddh") == 'f');
        assertTrue(streamSolution("aabcdf") == 'b');
        assertTrue(streamSolution("") == null);
    }

    public static Character mapSolution(String s){
        Character result = null;
        if(s == null || s.isEmpty() || s.isBlank())
            return result; 

        // map: char c of s -> # occurrences of c in s
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for(char c : s.toCharArray())
            if(map.get(c) == 1){
                result = c;
                break;
            }

        return result; 
    }

    public static Character streamSolution(String s){
        Character result = null;
        if(s == null || s.isEmpty() || s.isBlank())
            return result; 

        // map: char c of s -> # occurrences of c in s
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        // entrySet().stream() gives a stream of ENTRIES of the map. 
        // x is an entry of map, hence a pair <key, value> of the map!
        result = map.entrySet().stream()
                    .filter(x -> x.getValue() == 1)
                    .findFirst()
                    .get() // this get the first ENTRY that respect the filter
                    .getKey(); // of the first ENTRY we want the key, the char

        return result;
    }
}