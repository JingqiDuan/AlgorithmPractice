class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;
        int[] result = new int[rowNum * colNum];
        int row = 0;
        int col = 0;
        for(int i = 0; i < result.length; i++){
            result[i] = mat[row][col];
            if((row + col) % 2 == 0){
                if(col == colNum - 1){
                    row++;
                }else if(row == 0){
                    col++;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == rowNum - 1){
                    col++;
                }else if(col == 0){
                    row++;
                }else{
                    col--;
                    row++;
                }
            }
        }
        return result;
    }
}
