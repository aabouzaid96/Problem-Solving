Problem 
8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.

Same on LeetCode: 63. Unique Paths II
[https://leetcode.com/problems/unique-paths-ii]

class Solution {    
    private int memo[][];
    private int numberOfRows, numberOfColumns;

    private int getNumberOfPaths(int currentRow, int currentColumn, int obstacleGrid[][]){
    
        if((currentRow >= numberOfRows) || (currentColumn >= numberOfColumns))
            return 0;
        
        if(obstacleGrid[currentRow][currentColumn] == 1)
            return 0;
 
        if((currentRow == numberOfRows-1) && (currentColumn == numberOfColumns-1))
            return 1;
        
        if(memo[currentRow][currentColumn] != -1)
            return memo[currentRow][currentColumn];
        
        
        return memo[currentRow][currentColumn] = 
            getNumberOfPaths(currentRow+1, currentColumn, obstacleGrid) +
            getNumberOfPaths(currentRow, currentColumn+1, obstacleGrid);    
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        numberOfRows = obstacleGrid.length;
        numberOfColumns = obstacleGrid[0].length;
        memo = new int[numberOfRows][numberOfColumns];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
       return getNumberOfPaths(0, 0, obstacleGrid);
    }
}
