class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int currentVal = board[i][j];
                if(currentVal != '.'){
                    if(!seen.add(currentVal + "seen in row" + i)|| 
                        !seen.add(currentVal + "seen in column" + j)|| 
                        !seen.add(currentVal + "seen in sub box" + i / 3 + "-" + j / 3)){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}
