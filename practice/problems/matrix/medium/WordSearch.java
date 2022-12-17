package problems.matrix.medium;
/*
 * > PROBLEM 79 (medium): Word Search
 *   Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *   
 *   The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
 *   are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * > SOLUTION: 
 *   Four Direction DFS for each char that match the first char of the word. 
 *   Read the code. 
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A', 'B', 'C', 'E'}, 
            {'S', 'F', 'C', 'S'}, 
            {'A', 'D', 'E', 'E'}
        };

        System.out.println(solution(board, "SEE"));
    }

    public static boolean solution(char[][] board, String word){
        // for each element of the board, if the current element at index i,j
        // is equal to the first character of word then we begin the dfs from 
        // there as starting point for the dfs
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == word.charAt(0))
                    if(search(board, word, i, j, 0) == true)
                        return true; 

        return false;
    }

    // four direction DFS
    private static boolean search(
        char[][] board, 
        String word, 
        int row, 
        int column, 
        int matched
    ){ 
        if(matched == word.length())
            return true;

        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length)
            return false; 

        if(board[row][column] != word.charAt(matched))
            return false;

        board[row][column] = '#';
        
        boolean result = 
            search(board, word, row, column +1, matched + 1) ||
            search(board, word, row, column -1, matched + 1) ||
            search(board, word, row +1, column, matched + 1) ||
            search(board, word, row -1, column, matched + 1);

        board[row][column] = word.charAt(matched);

        return result; 
    }
}
