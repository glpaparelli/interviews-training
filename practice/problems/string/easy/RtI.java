package problems.string.easy;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 13 (easy): Roman to Integer
 *   Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *     Symbol        Value
 *       I             1
 *       V             5
 *       X             10
 *       L             50
 *       C             100
 *       D             500
 *       M             1000
 * 
 *   For example 2 is written as II...
 *   Roman numerals are usually written largest to smallest from left to right. However the numer
 *   four is not IIII. Insted the number four is IV. Because the one is before the fiwe we subtract it 
 *   making four. The same principle applies to number nine. There are six instances where subtraction
 *   is used: 
 *      - I can be place before V and X to make 4 and 9
 *      - X can be placed before L and C to make 40 and 90
 *      - C can be placed before D and M to make 400 and 900
 * 
 *   Given a roman numeral, convert it to an integer. 
 * 
 * > SOLUTION:
 *   check the comments!
 */
public class RtI {
    public static void main(String[] args) {
        assertTrue(solution("III") == 3); 
        assertTrue(solution("LVIII") == 58); 
        assertTrue(solution("MCMXCIV") == 1994); 
    }

    public static int solution(String s){
        int result = 0; 
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if(s.length() == 1)
            return map.get(s.charAt(0));

        int previous; 
        int current; 
        int last = map.get(s.charAt(s.length()-1));

        for(int i = 1; i < s.length(); i++){
            previous = map.get(s.charAt(i-1));
            current = map.get(s.charAt(i));
            
            // no subraction here
            if(previous >= current)
                result = result + previous; 
            else{
                // here we have a subtraction
                result = result + (current - previous);
                // this i++ makes the for exit in the case of  
                // numbers that ends with a subtraction, see below
                i++; 
            }
            
            // here and not outside the for: what if a number ends 
            // with a subtraction? eg ----IV
            if(i == s.length()-1)
                result = result + last;
        }

        return result;
    }
}