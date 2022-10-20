package problems.binarysearch;
/*
 * > PROBLEM 74 (medium): Search a 2D Matrix
 *   Write an efficient algorithm that searches for a value target in an m x n 
 *   integer matrix matrix. This matrix has the following properties:
 *      1) Integers in each row are sorted from left to right.
 *      2) The first integer of each row is greater than the last integer of 
 *         the previous row.
 * 
 * > SOLUTION: 
 *   It's a binary search to find the row and a binary search in that row to find target
 */
public class Sa2DM {
    public static boolean solution(int[][] matrix, int target){
        if(matrix.length == 1)
            return binarySearch(matrix[0], target);

        int start = 0; 
        int end = matrix.length - 1; 
        int rowIndex = 0;
        
        while(start <= end){
            rowIndex = (start + end) / 2;
            int rowLength = matrix[rowIndex].length;

            if(matrix[rowIndex][0] == target)
                return true;

            // target is included in this row;
            if(target > matrix[rowIndex][0] && target <= matrix[rowIndex][rowLength-1])
                return binarySearch(matrix[rowIndex], target);
            
            if(matrix[rowIndex][0] > target)
                end = rowIndex - 1;
            else
                start = rowIndex + 1;
        }
        return false;        
    }

    private static boolean binarySearch(int[] array, int target){
        int start = 0; 
        int end = array.length -1; 
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;

            if(array[mid] == target)
                return true;

            if(array[mid] > target)
                end = mid - 1;

            if(array[mid] < target)
                start = mid + 1;
        }

        return false;
    }
}
