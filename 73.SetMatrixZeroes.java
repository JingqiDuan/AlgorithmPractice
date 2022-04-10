class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        if(rowSet.size() > 0){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(rowSet.contains(i) || colSet.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
