package problems.matrix;
import java.util.HashSet;
import java.util.Set;
/*
 * > PROBLEM 36 (medium): Valid Sudoku
 *   Ddetermine if a 9x9 sudoky board is valid. Only the filled cells need to 
 *   be validated according to the following rules: 
 *      - each row must contain the digits 1-9 without repetition
 *      - each column must contain the digits 1-9 without repetition
 *      - each of the nine 3x3 sub-boxes of the grid must contain the digits 
 *        1-9 without repetition
 * 
 *   Note: a partially filled sudoku board could be valid but is not
 *         necessary solvable
 *   
 * > SOLUTION:
 *   it's all in the code
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] input1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'}, 
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assert(solution(input1));

        char[][] input2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assert(!solution(input2));
    }

    public static boolean solution(char[][] board){
        // 3 main steps: 
        // 1) check if rows have repetitions
        // 2) check if columns have repetitions
        // 3) check if sub-square have repetitions

        // used to keep track of the already seen elements
        Set<Character> set = new HashSet<>();

        // step 1 and 2
        for(int i = 0; i < 9; i++){
            // step 1: check if rows contains duplicates
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.' && set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);

            set.clear();
                
            // step 2: check if columns contains duplicates
            for(int j = 0; j < 9; j++)
                if(board[j][i] != '.' && set.contains(board[j][i]))
                    return false;
                else
                    set.add(board[j][i]);   

            set.clear();
        }

        // step 3: check if sub-boxes contains duplicates
        // we explore sub boxes left to right starting from 
        // the top left corner

        // row and column represent the 'start' of the box, aka the 
        // first element of the subsqure: for the first subbox row = 0 and column = 0, 
        // for the second subsquare row = 0 and column = 3 and so on
        int row = 0; 
        int column = 0; 
        // the counter of the row subbox we are checking: 0 means we are checking
        // the leftmost subbos of the current row, 1 the subbox in the middle and
        // 2 means we are checking the last subbox
        int counter = 0; 

        while(row < 9 && column < 9){
            while(counter < 3){
                for(int i = row; i < row + 3; i++)
                    for(int j = column; j < column + 3; j++)
                        if(board[i][j] != '.' && set.contains(board[i][j]))
                            return false;
                        else
                            set.add(board[i][j]);

                set.clear();
                counter++; 
                column = column + 3;
            }

            column = 0;
            counter = 0; 
            row = row + 3; 
        }

        return true; 
    }
}
