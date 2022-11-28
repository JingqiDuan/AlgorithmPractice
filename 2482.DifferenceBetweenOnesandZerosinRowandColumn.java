class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] result = new int[rows][cols];
        int[] rowOne = new int[rows], colOne = new int[cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    rowOne[i]++;
                    colOne[j]++;
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result[i][j] = rowOne[i] + colOne[j] - (rows - rowOne[i]) - (cols - colOne[j]);
            }
        }
        return result;
    }
}
