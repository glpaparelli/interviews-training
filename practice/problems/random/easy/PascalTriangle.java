package problems.random.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * > PROBLEM 118 (easy): Pascal's Triangle
 *   Given an integer numRows, return the first nummRows of Pascal's Triangle
 * 
 *   In Pascal's Triangle each number is the sum of the two numbers directly above it
 * 
 * > SOLUTION: 
 *   The solution is trivial if we notice some key points: 
 *      1) starting with an index = 1, the row_index has index elements
 *          - the 6-th row has 6 elements
 *          - we can also shift: the first row row_0 has 1 element, the second row 
 *            row_1 has 2 elements, ... 
 *      2) the first and last element of every row is 1
 *      3) given a row k then row_k[i] = row_k-1[i-1] + row_k-1[i]
 *          - an element of the triangle is the sum of the two numbers directly above it
 *          - it is not row_k-1[i+1] because row_k-1 has one element less than row_[k]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> rows = solution(7);

        for(List<Integer> row : rows){
            row.forEach(x -> System.out.print(" " + x + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> solution(int numRows){
        if(numRows == 1)
            return List.of(List.of(1));

        // create the 2 standard rows of the triangle
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(List.of(1));
        rows.add(List.of(1,1));

        // for each row that we have to build 
        for(int k = 2; k < numRows; k++){
            // we know beforehand how many element this row will have: 
            // if we start with an index 0 (row_0 is the first row) then 
            // every row has its index+1 elements
            List<Integer> row_k = Arrays.asList(new Integer[k+1]);
            // first and last elements of the row are always 1
            row_k.set(0, 1);
            // notice that since the row k has k+1 elements the last element 
            // is at index k, super handy
            row_k.set(k, 1);

            // for each element of the row (except the 
            // first 1 (index 0) and the last one (index k))
            for(int i = 1; i < k; i++){
                List<Integer> row_km1 = rows.get(k-1); // km1 = k minus 1
                row_k.set(i, row_km1.get(i-1) + row_km1.get(i));
            }
            rows.add(row_k);
        }
        return rows; 
    }
}
