package problems.matrix;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
/*
 * > PROBLEM 54 (medium): Spiral Matrix
 *   Given an m x n matrix, returl all elements of the matrix in spiral order
 * 
 * > SOLUTION: 
 *   The approach is the obvious one, it is just boring to 
 *   develop because of the indices. 
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        List<Integer> output1 = solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assert(output1.equals(List.of(IntStream.range(1, 10))));
        
        List<Integer> output2 = solution(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        assert(output2.equals(List.of(1,2,3,4,12,11,10,9,5,6,7)));
    }

    public static List<Integer> solution(int[][] matrix){
        List<Integer> result = new ArrayList<>(); 

        if (matrix == null || matrix.length == 0) 
            return result;

        int matrixSize = matrix.length * matrix[0].length;
        int up = 0,  down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (result.size() < matrixSize) {
            // add elements of the the topmost row from left to rigth
            for (int j = left; j <= right && result.size() < matrixSize; j++)
                result.add(matrix[up][j]);
            // add elements of the rightmost column from top to down
            for (int i = up + 1; i <= down - 1 && result.size() < matrixSize; i++)
                result.add(matrix[i][right]);
            // add elements of the bottomest row from right to left   
            for (int j = right; j >= left && result.size() < matrixSize; j--)
                result.add(matrix[down][j]);
            // add elements of the leftmost column from down to top   
            for (int i = down - 1; i >= up + 1 && result.size() < matrixSize; i--) 
                result.add(matrix[i][left]);
                
            left++; right--; up++; down--; 
        }

        return result;
    }
}