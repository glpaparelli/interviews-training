package problems.matrix.hard;
/*
 * > PROBLEM 37 (hard): Sudoku Solver
 *   Write a program to solve a Sudoky puzzle by filling the empty cells
 *   A sudoku solution must satisfy all of the following rules: 
 *      1) each of the digits 1-9 must occur exactly once in each row
 *      2) each of the digits 1-9 must occur exactly once each column
 *      3) each of the digits 1-9 must occur exactly once in each of the 9
 *         3x3 subboxes of the grid
 * 
 *   The '.' character indicates empty cells
 * 
 * > SOLUTION: 
 *   All in the comments, not my solution btw, boring problem. 
 */
public class SudokuSolver {
    public static void main(String[] args) {
        // void
    }

    public void solution(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        // if the col is 9, that means you've filled out a whole row. 
        // start the search on the next row by resetting column and 
        // incrementing the row by 1
        if (col == board[0].length) {
            col = 0;
            row += 1;
        }

        // if you've reached row == 9, that means you didn't run into any errors 
        // with your blocks in the previous rows, so you have a valid solution
        if (row == board.length) 
            return true; 
        
        // if this piece already has a value, check the next square
        if (board[row][col] != '.') 
            return solve(board, row, col+1);
        
        // we want to try every number for this block
        for (char num = '1'; num <= '9'; num++) {
            // don't run this if the number isn't a valid answer
            if (checkIfValid(board, row, col, num)) {
                // Set the value of the current square to the valid num
                board[row][col] = num;

                // run for the next square over
                boolean solved = solve(board, row, col+1);

                // the only way we can trigger a true is if we got to the end, 
                // so if it's true that means we have a solved board 
                if (solved) 
                    return true;   
                else 
                    // If our board isn't solved, backtrack and try the next number
                    board[row][col] = '.';
            }
        }

        // this is when every value of the board is filled, 
        // because you don't run anything on it.
        // if you get to this step, that means that no values fit, 
        // which means the current iteration of the board is wrong so return 
        // false and try the previous step again with a different value
        return false;
    }

    public boolean checkIfValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            // check the column for duplicates
            if (board[i][col] == value) 
                return false; 

            // Check the row for duplicates
            if (board[row][i] == value) 
                return false;
        }

        // this generates our "box", for [1, 1] for example, 
        // this pair will be the box bound by [0, 2] and [0,2]
        int boxRow = row / 3;
        int boxCol = col / 3;

        for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
            for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
                // check the box for duplicates
                if (board[i][j] == value) return false;
            }
        }

		// there are no falses, therefore this is a valid number to put on the square
        return true;
    }
}
