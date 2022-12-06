package problems.matrix.medium;
import java.util.Arrays;
/*
 * > PROBLEM 48 (medium): Rotate Image
 *   You are given a NxN 2D matrix representing an image, rotate the image
 *   by 90 degrees clockwise. 
 * 
 *   You have to rotate the image in-place, which means you have to modify the 
 *   input matrix directly. Do not allocate another matrix to do the rotation.
 * 
 * > SOLUTION: 
 *   The best solution for rotating the matrix is to firstly reverse the matrix 
 *   around the main diagonal, and then reverse it from left to right.
 *   These operations are called transpose and reflect in linear algebra
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] input1 = {
            {1,2,3},
            {4,5,6}, 
            {7,8,9},
        };
        for(int[] row : input1)
            System.out.println(Arrays.toString(row));

        System.out.println("\n");
        solution(input1);

        for(int[] row : input1)
            System.out.println(Arrays.toString(row));
    }

    public static void solution(int[][] matrix){
        transpose(matrix);
        reflect(matrix);
    }

    // the matrix gets reversed: the last element of each row becomes the first
    // and so on
    private static void reflect(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix.length / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -j-1];
                matrix[i][matrix.length -j-1] = tmp;
            }
    }

    // the column of the matrix become the row of the matrix, aka 
    // the matrix elements are swapped across the main diagonal
    private static void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++)
            for(int j = i+1; j < matrix.length; j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
    }
}
