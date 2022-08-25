package problems.recursion;
import java.util.ArrayList;
import java.util.List;
/*
 * > PROBLEM 17 (medium): Letter Combinations of a Phone Number
 *   Given a string containing digits from 2-9 inclusive, return all possible
 *   letter combinations that the number could represent. Return the answer
 *   in any order. 
 *   The mapping is the standard "old cellphone with 10-key".
 * 
 * > SOLUTION: 
 *   Classic backtracking scheme. We use an array as a map for the letters
 *   - eg: "23"
 *   - 2 -> abc
 *     - a
 *      - 3 -> def
 *        - ad 
 *          - add to list
 *        - a
 *        - ae
 *          - add to the list
 *      ...
 */
public class LCoaPN {
    public static void main(String[] args) {
        List<String> output1 = solution("23");
        output1.forEach(x -> System.out.print(x+" "));

        System.out.println();

        List<String> output2 = solution("");
        output2.forEach(x -> System.out.print(x+" "));

        System.out.println();

        List<String> output3 = solution("2");
        output3.forEach(x -> System.out.print(x+" "));
    }

    public static List<String> solution(String digits){
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, map, 0);

        return result;
    }

    public static void backtrack(
        List<String> result, 
        StringBuilder sb, 
        String digits, 
        String[] map, 
        int start
    ){
        if(start == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String lettersOfNum = map[digits.charAt(start) - '0'];
        for(int i = 0; i < lettersOfNum.length(); i++) {
            sb.append(lettersOfNum.charAt(i));
            backtrack(result, sb, digits, map, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
