class Solution {
    public void rotate(int[][] matrix) {
        //Transpose first, then exchange values with their mirror symmetry
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int tem = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tem;             
            }
        }
       
         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix.length/2; j++){
                 int tmp = matrix[i][matrix.length - 1 -j];
                 matrix[i][matrix.length - 1 - j] = matrix[i][j];
                 matrix[i][j] = tmp;
             }
            }
        }
    }
