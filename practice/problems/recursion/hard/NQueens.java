package problems.recursion.hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * > PROBLEM 51 (hard): N-Queens
 *   The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 *   such that no two queens attack each other.
 *   Given an integer "n", return all distinct solutions to the n-queens puzzle. 
 *   You may return the answer in any order.
 * 
 *   Each solution contains a distinct board configuration of the n-queens' placement, 
 *   where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * 
 * > SOLUTION: 
 *   Classic backtrack scheme: just use boolean arrays to remember which row, column 
 *   and diagonals are used by another queen. 
 */
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> output1 = solution(4);
        output1.forEach(x -> x.forEach(y -> System.out.println(y)));

        System.out.println();
        List<List<String>> output2 = solution(1);
        output2.forEach(x -> x.forEach(y -> System.out.println(" " + y + " ")));
    }

    public static List<List<String>> solution(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<1)
            return result;

        solve(
            result, 
            new ArrayList<String>(), 
            n, 
            0,
            new boolean[n], 
            new boolean[2*n], 
            new boolean[2*n]
        );
        
        return result;
    }

    /**
     * @param result list of possible solutions
     * @param cur current solution
     * @param n size of the chess board
     * @param currentRow row we are currently placing a queen
     * @param columns columns check array
     * @param mDiags "main diagonal" oriented diagonals check array
     * @param aDiags "anti diagonal" oriented diagonals check array
     */
    public static void solve(
        List<List<String>> result, 
        List<String> cur,
        int n, 
        int currentRow, 
        boolean[] columns, 
        boolean[] mDiags, 
        boolean[] aDiags
    ){
        if(currentRow == n){
            result.add(new ArrayList<String>(cur));
            return;
        }

        for(int i = 0; i < n; i++){
            int d1 = currentRow + i;
            int d2 = i - currentRow + n - 1;
            
            // if the i-th column is not used and 
            // if the diagonal d1 and d2 are not used
            // then we can place a queen in this spot
            if(!columns[i] && !mDiags[d1] && !aDiags[d2]){
                    columns[i] = true;
                    mDiags[d1] = true;
                    aDiags[d2] = true;

                    char[] helpChars = new char[n];
                    Arrays.fill(helpChars,'.');

                    helpChars[i]='Q';
                    cur.add(new String(helpChars));
        
                    solve(result, cur, n, currentRow+1, columns, mDiags, aDiags);
                    
                    columns[i]=false;
                    mDiags[d1]=false;
                    aDiags[d2]=false;
                    cur.remove(cur.size()-1);
                }
        }
    }
}
