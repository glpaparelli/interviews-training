package problems.dynamicprogramming.medium;
/*
 * > PROBLEM 62 (medium): Unique Paths
 *   There is a robot on an m x n grid. The robot is initially located at the
 *   top-left corner (i.e., grid[0][0]). The robot tries to move to the 
 *   bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either
 *   down or right at any point in time. 
 *   
 *   Given the two integers m and n, return the number of possible unique paths
 *   that the robot can take to reach the bottom-right corner
 * 
 * > SOLUTION: 
 *   Simply use Bottom-Up DP where the dynamic programming matrix grid[i][j] stores
 *   the number of unique paths to reach the cell <i,j>. 
 *   Se the code with comments.
 */
public class UniquePaths {
    public static void main(String[] args) {
        assert(solution(3,7) == 28);
        assert(solution(3,2) == 3);
    }

    public static int solution(int m, int n){
        if(m <= 0 || n <= 0)
            return 0;

        int[][] grid = new int[m][n];

        // base cases:
        // the robot starts here, there are 0 possible routes
        grid[0][0] = 0; 

        // the first column is all set to 1: the robot moves either down or
        // right, the leftmost cells are reachable only from the start going down
        for(int i = 0; i < m; i++)
            grid[i][0] = 1;

        // the first row is all set to 1: the cells in the first row are reachable
        // only going right from the starting point
        for(int j = 0; j < n; j++)
            grid[0][j] = 1;

        // now we compute the #routes to reach the cell [i][j] using the
        // #routes to reach the cell [i-1][j] (from which we can reach [i][j] 
        // with 1 move down) and the #routes to reach the cell [i][j-1] (from 
        // which we can reach the cell [i][j] with 1 move right)
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] = grid[i][j-1] + grid[i-1][j]; 

        return grid[m-1][n-1];
    }
}
