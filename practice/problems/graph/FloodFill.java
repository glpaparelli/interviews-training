package problems.graph;
/*
 * > PROBLEM 733 (easy): Flood Fill
 *   An image is represented by an m x n integer grid image where image[i][j] represents
 *   the pixel value of the image.
 *   
 *   You are also given three integers startRow, startColumn, and color. You should perform a flood fill 
 *   on the image starting from the pixel image[startRow][startColumn].
 * 
 *   To perform a flood fill, consider the starting pixel, plus any pixels connected 
 *   4-directionally to the starting pixel of the same color as the starting pixel, 
 *   plus any pixels connected 4-directionally to those pixels (also with the same color), 
 *   and so on. Replace the color of all of the aforementioned pixels with color.
 * 
 *   Return the modified image after performing the flood fill.
 * 
 * > SOLUTION: 
 *   we simply do a dfs on adjacent neighbors
 */
public class FloodFill {
    public int[][] solution(int[][] image, int startRow, int startColumn, int newColor){
        int color = image[startRow][startColumn];
        if(color != newColor)
            dfs(image, startRow, startColumn, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int column, int color, int newColor) {
        if(image[row][column] == color){
            image[row][column] = newColor;

            if(row >= 1)
                dfs(image, row-1, column, color, newColor);

            if(column >= 1)
                dfs(image, row, column-1, color, newColor);

            if(row + 1 < image.length)
                dfs(image, row+1, column, color, newColor);
                
            if(column + 1 < image[0].length)
                dfs(image, row, column+1, color, newColor);
        }
    }
}