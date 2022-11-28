package problems.graph;
import java.util.LinkedList;
import java.util.Queue;
/*
 * > PROBLEM 542 (medium): Zero-One Matrix
 *   Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *   The distance between two adjacent cells is 1.
 * 
 *   - the returning matrix has the following meaning: 
 *       result[i][j] = k -> the nearest 0 to the element in mat[i][j] is at distance k
 * 
 * > SOLUTION:
 *   // TODO comments, test and understanding
 */
public class ZOMatrix {
    public int[][] solution(int[][] matrix){
        Queue<int[]> frontier = new LinkedList<>();

        int rows = matrix.length; 
        int columns = matrix[0].length;

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                if(matrix[i][j] == 0)
                    frontier.add(new int[]{i,j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(frontier.isEmpty() == false){
            int[] cell = frontier.poll();

            for(int[] direction : directions){
                int newRow = cell[0] + direction[0];
                int newColumn = cell[1] + direction[1];

                // if the new cell is out of bounds or it is already 
                // closer to another 0 we stop bfs in this cell
                if(newRow < 0 || 
                   newRow >= rows || 
                   newColumn < columns ||
                   newColumn >= columns ||
                   matrix[newRow][newColumn] <= matrix[cell[0]][cell[1]] + 1
                )
                    continue;

                frontier.add(new int[]{newRow, newColumn});
                matrix[newRow][newColumn] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }
}
