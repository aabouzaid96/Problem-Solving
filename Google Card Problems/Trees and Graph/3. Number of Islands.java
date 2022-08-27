class Solution {
                          // up  left down right
    private int[] directionX = new int[]{-1,0,1,0};
    private int[] directionY = new int[]{0,-1,0,1};
    private int rows, cols;
    private boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        int islandsCount =0;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islandsCount++;    
                    dfs(i, j, grid);
                }
            }
        }
        return islandsCount;
    }
    private void dfs(int x, int y, char[][] grid){
         
        visited[x][y] =  true;

         for(int i=0;i<4;i++){
             int currentX = x  + directionX[i];
             int currentY = y  + directionY[i];
             if(validateNode(currentX, currentY, grid)){
                dfs(currentX, currentY, grid);
             }
         }
        return;
    }
    private boolean validateNode(int x, int y, char[][]grid){
        if(x >= 0 && x< rows && y>=0 && y < cols && grid[x][y] == '1' && !visited[x][y])
            return true;
        return false;    
    }
}
    
