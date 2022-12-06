package problems.string.easy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 125 (easy): Valid Palindrome
 *   A phrase is a palindrome if, after converting all uppercase letters into 
 *   lowercase and removing all non-alphanumeric characters, it reads the same 
 *   forward and backward. 
 *   Alphanumeric characters include letters and numbers.
 * 
 *   Given a string "s", return true if s is palindrome, or false otherwise
 * 
 * > SOLUTION:
 *   Use two indexes, one that points at the start of the string
 *   and one that points at the end. While s[start] == s[end] you 
 *   move right the start pointer and left the end pointer. 
 *   If the two pointers meet the string is palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        assertTrue(solution("A man, a plan, a canal: Panama"));
        assertFalse(solution("race a car"));
        assertTrue(solution(" "));
    }

    public static boolean solution(String s){
        if(s == null)
            return false;
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i = 0, j = s.length()-1; i <= j; i++, j--)
            if(s.charAt(i) != s.charAt(j))
                return false;
            
        return true;
    }
}
