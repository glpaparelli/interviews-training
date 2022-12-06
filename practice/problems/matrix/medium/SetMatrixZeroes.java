package problems.matrix.medium;
/*
 * > PROBLEM 73 (medium): Set Matrix Zeroes
 *   Given an MxN integer matrix, if an element is 0, set its entire row 
 *   and column to 0's. 
 *   This must be done in place.
 * 
 * > SOLUTION: 
 *   Coloring approach, the code is simple. 
 *   Leetcode fails since they considered the case where in the matrix there 
 *   is Integer.MIN_VALUE
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        // void
    }

    public static void solution(int[][] matrix){
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0){
                    // color row and columns that have to be zeroed
                    colorRow(matrix, i);
                    colorColumn(matrix, j);
                }
        
        // set to zero all the colored numbers
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == Integer.MIN_VALUE)
                    matrix[i][j] = 0;
    }

    private static void colorColumn(int[][] matrix, int j) {
        for(int i = 0; i < matrix.length; i++)
            // we color a column in which a zero has already been foudn
            // we do not color other zeroes because they have an effect 
            // yet to come and they will be handled later on
            if(matrix[i][j] != 0)
                matrix[i][j] = Integer.MIN_VALUE;
    }

    private static void colorRow(int[][] matrix, int i) {
        for(int j = 0; j < matrix[0].length; j++)
            if(matrix[i][j] != 0)
                matrix[i][j] = Integer.MIN_VALUE;
    }
}
