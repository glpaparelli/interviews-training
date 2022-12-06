package problems.recursion.medium;
import java.util.ArrayList;
import java.util.List;
/*
 * > PROBLEM 22 (medium): Generate Parantheses
 *   Given "n" pairs of paranthesesm write a function to generate
 *   all combinations of well-formed parentheses 
 * 
 * > SOLUTION: 
 *   Classic recursive scheme: we open untill we can and we close until 
 *   we have opened parentheses.
 * 
 *   eg: n = 2 
 *   - (
 *   - ((
 *   - (()
 *   - (()) // add to list
 *   - (()
 *   - ()
 *   - ()(
 *   - ()() // add to list
 *   - end
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> output1 = solution(3);
        output1.forEach(x -> System.out.print(x+" "));

        System.out.println();

        List<String> output2 = solution(1);
        output2.forEach(x -> System.out.print(x+" "));
    }

    public static List<String> solution(int n){
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(
        int n, 
        int opened, 
        int closed, 
        StringBuilder current, 
        List<String> result
    ){
        if(current.length() == n*2){
            result.add(current.toString());
            return;
        }

        if(opened < n){
            current.append("(");
            backtrack(n, opened+1, closed, current, result);
            current.deleteCharAt(current.length()-1);
        }
        
        if(closed < opened){
            current.append(")");
            backtrack(n, opened, closed+1, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }
}
