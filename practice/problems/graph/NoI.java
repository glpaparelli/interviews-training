package problems.graph;
import java.util.HashSet;
import java.util.Set;
/*
 * > PROBLEM 200 (medium): Number of Islands
 *   Given an m x n 2D binary grid grid which represents a map of '1's (land) 
 *   and '0's (water), return the number of islands.
 * 
 *   An island is surrounded by water and is formed by connecting adjacent 
 *   lands horizontally or vertically. 
 *   You may assume all four edges of the grid are all surrounded by water.
 * 
 * > SOLUTION: 
 *   TODO
 */
public class NoI {
    public static int solution(char[][] grid){
        int[] counter = new int[1];
        counter[0] = 0;
        Set<int[]> visited = new HashSet<>();
        helper(grid, 0, 0, visited, counter);

        return 0;
    }

    private static void helper(
        char[][] grid, 
        int row, 
        int col, 
        Set<int[]> visited,
        int[] counter
    ){  
        visited.add(new int[]{row, col});

        // this cell is land?
        if(grid[row][col] == '1'){
            // this cell is an island by itself?
            if(isIsland(grid, row, col) == true){
                counter[0]++;
                return;
            }

            // if it is not an isolated iland it may be a component
            // of a bigger island: if all 

        }
    }

    private static boolean isIsland(char[][] grid, int row, int col) {
        return false;
    }

    // private void dfs([][] image, int row, int column, int color, int newColor) {
    //     if(image[row][column] == color){
    //         image[row][column] = newColor;

    //         if(row >= 1)
    //             dfs(image, row-1, column, color, newColor);

    //         if(column >= 1)
    //             dfs(image, row, column-1, color, newColor);

    //         if(row + 1 < image.length)
    //             dfs(image, row+1, column, color, newColor);
                
    //         if(column + 1 < image[0].length)
    //             dfs(image, row, column+1, color, newColor);
    //     }
    // }
}
