package problems.dynamicprogramming.medium;
/*
 * > PROBLEM 221 (medium): Maximal Square
 *   Given an m*n binary matrix filled with 0's and 1's, find the 
 *   largest square containing only 1's and return its area.
 * 
 * > SOLUTION: Dynamic Programming approach
 *   We initialize another matrix (dp) with the same dimensions as the 
 *   original one, initialized with all 0's. 
 * 
 *   dp[i][j] represents the side length of the maximum square whose bottom 
 *   right corner is the cell with index (i,j) in the original matrix. 
 * 
 *   Starting from (0,0), for every 1 found in the original matrix, we update
 *   the value of the current element as: 
 *      - dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
 * 
 *   We also remember the size of the largest square found so far. In this way 
 *   we traverse the original matrix once and find out the required maximum size.
 *   
 *   This gives the side lenght of the square (say maxSide). The required result is 
 *   the area maxSide^2
 * 
 *   Example: let's consider the following matrix:
 *                0 1 1 1 0
 *                1 1 1 1 0
 *                0 1 1 1 1
 *                0 1 1 1 1
 *                0 0 1 1 1
 * 
 *  - check the code, also the better solution
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] input1 = {
            {'1','0','1','0','0'}, 
            {'1','0','1','1','1'}, 
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        assert(betterSolution(input1) == 4);

        char[][] input2 = {
            {'0', '1'},
            {'1', '0'}
        };
        assert(betterSolution(input2) == 1);

        char[][] input3 = {{'0'}};
        assert(betterSolution(input3) == 0);
    }

    public static int solution(char[][] matrix){
        // if the matrix has only one row the max square is a single 1
        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++)
                if(matrix[0][i] == 1)
                    return 1;
            return 0; 
        }

        int rows = matrix.length; 
        int cols = matrix[0].length;
        int maxSide = Integer.MIN_VALUE;

        // at instantiation java already fills the matrix 
        // with 0's, no need to use Arrays.fill
        // dp has one extra row and one extra colum to fix the base cases: 
        // everything is shifted by 1
        int[][] dp = new int[rows+1][cols+1]; 

        
        for(int i = 1; i <= rows; i++)
            for(int j = 1; j <= cols; j++)
                // for every cell of the original matrix the: the left adjacent diagonal cell was 1?
                if(matrix[i-1][j-1] == '1'){
                    /* 
                        if so then dp[i][j] (aka the max length of the square of all 1's with 
                        the right bottom corner in (i,j)) is the minimum +1 between
                          - the max length of the square side that has bottom corner 
                            in the cell adjacent to the left to this one
                          - the max length of the square side that has bottom corner in
                            the cell adjacent right above to this one
                          - the max length of the square side that has bottom corner in 
                            the cell adjacent diagonally left to this one

                        we see how it is crucial the intuition of the bottom corner: 
                        basically the current cell we consider 'can only be' the bottom 
                        rigth corner of a bigger square. 
                        Otherwise: since we are picking the minimum a 0 would return and 
                        the +1 will take care of setting a square of length 1.
                    */
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
        
        return maxSide * maxSide;
    }

    /*
        in the previous solution for calulating the dp of the i-th row we are using only
        the previous element and the (i-1)-th row. Therefore we don't need 2D dp matrix as 1 dp
        array will be sufficient for this. 

        Initially the dp array contains all 0'. As we scan the elements of the original matrix across
        a row, we keep on updating the dp array as per the equation dp[j] = min(dp[j-1], dp[j], prev), 
        where prev refers to the old dp[j-1]. 
        For every row we repeat the process and update in the same dp array
    */
    public static int betterSolution(char[][] matrix){
        // if the matrix has only one row the max square is a single 1
        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++)
                if(matrix[0][i] == 1)
                    return 1;
            return 0; 
        }

        int rows = matrix.length; 
        int cols = matrix[0].length;
        int[] dp = new int[cols + 1];

        int maxSide = 0; 
        int prev = 0;

        for(int i = 1; i <= rows; i++) 
            for(int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i - 1][j - 1] == '1') {
                    dp[j] = min(dp[j - 1], prev, dp[j]) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                } else 
                    dp[j] = 0;
                
                prev = temp;
            }
        
        return maxSide * maxSide;
    }

    // just for clarity and to avoid math.min innested in the main code
    static private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
