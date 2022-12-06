package problems.string.easy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/*
 * > PROBLEM 20 (easy): Valid Parentheses
 *   Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 *   determine if the input string is valid.
 *      
 *   An input string is valid if:
 *      - open brackets must be closed by the same type of brackets.
 *      - open brackets must be closed in the correct order.
 *      - Every close bracket has a corresponding open bracket of the same type.
 * 
 * > SOLUTION: 
 *   // read the code
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(solution("()"));
        System.out.println(solution("()[]{}"));
        System.out.println(solution("(]"));
    }

    public static boolean solution(String s){
        // list of still opened parenthesis so far in s
        LinkedList<Character> stillOpen = new LinkedList<>();

        // associate to an open parenthesis the corresponding closing parenthesis
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        // dictionary of opened parenteses
        String opened = "{[(";

        for(char c : s.toCharArray()){

            // adding is free, it can't lead to problems
            // if c is an opened parenthesis then we add it
            // to the list of opened parenthesis so far
            if(opened.indexOf(c) != -1)
                stillOpen.add(c);
            else{
                // if c is a closing parenthesis there are few cases:
                
                // case1: the list of still opened parenthesis is empty: this parenthesis can
                // not ever be balanced, the string is not valid
                //   - e.g: "]----", surely not valid
                if(stillOpen.size() == 0)
                    return false;

                // case 2: c is a the closing parenthesis of the last opened parenthesis, 
                // which is a valid case: we remove the last opened parenthesis 
                // from the list of opened since it has been closed
                if(c == map.get(stillOpen.getLast()))
                    stillOpen.removeLast();
                
                // case 3: c is a closing parenthesis but it is not the closing parenthesis 
                // of the last opened parenthesis, which lead to an invalid string
                //   - e.g: c is ] and the last opened is (, the string is ---(--]
                //     and it is invalid
                else
                    return false; 
            }
        }

        // if there are still opened parnetheses left the string is not valid
        return stillOpen.isEmpty();
    }
}