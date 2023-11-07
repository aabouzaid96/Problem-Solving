Problem https://www.lintcode.com/problem/1042/description?fromId=18&_from=collection

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;       // rows   3
        int columns = matrix[0].length;  // columns  4
    
        // check digaonals for row
        for(int l=0;l<columns;l++){ // 0
            int curVal = matrix[0][l]; //0,0 => 1 , 1,1=>1  , 2,2
            int i=1, j=l+1;   // i=1 j=1  
            while(i < rows && j < columns){ 
                if(matrix[i][j] != curVal) return false;
                i++;
                j++;
            }
        }

        // check digaonals for column
        for(int l=1;l<rows;l++){ 
            int curVal = matrix[l][0];
            int i=l+1, j=1;   
            while(i < rows && j < columns){ 
                if(matrix[i][j] != curVal) return false;
                i++;
                j++;
            }
        }

        return true;
    }
}
