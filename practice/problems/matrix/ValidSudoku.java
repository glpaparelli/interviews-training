package problems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ValidSudoku {

    public static void main(String[] args) {
      
    }

    public boolean solution(int[][] board){
        boolean result = true;

        for(int i = 0; i < 10; i++)
            if(!checkRow(board, i) || !checkColumn(board, i))
                return false;

     
        for(int i = 0; i < 9; i = i+3)
            for(int j = 0; j < 9; j = j+3)
                if(!checkBox(board, i, j))
                    return false;
        
        
                
        return result; 
    }

    /**
     * @param board the sudoku board
     * @param row the row coordinate of the subbox to check
     * @param column the column coordinate of the subbox to check
     * @return true if the subbox is valid
     */
    private boolean checkBox(int[][] board, int row, int column) {
        boolean result = true;

        Set<Character> subbox = new HashSet<>();

        for(int i = row; i < row + 3; i++)
            for(int j = column; j < column + 3; j++)
                if(subbox.contains(board[i][j]))
                    return false;

        return result;
    }

    private boolean checkColumn(int[][] board, int column) {
        int count = (int) IntStream
            .range(0, board.length)
            .map(i -> board[i][column])
            .filter(x -> x != -1)
            .distinct()
            .count();

        return count == 9;
    }

    private boolean checkRow(char[][] board, int row) {
        int count = (int) IntStream
        .range(0, board.length)
        .map(i -> board[row][i])
        .filter(x -> x != -1)
        .distinct()
        .count();

        return count == 9;
    }
}
