class Solution {
    public boolean exist(char[][] board, String word) {
        int rowNum = board.length;
        int colNum = board[0].length;
        char[] wordChar = word.toCharArray();
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(helper(board, wordChar, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] wordChar, int x, int y, int index){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != wordChar[index]){
            return false;
        }
        if(index == wordChar.length - 1){//mind the index starting from 0
            return true;
        }
        int[][] adj = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        //mark current path
        board[x][y] = '\0';
        for(int i = 0; i < 4; i++){
            if(helper(board, wordChar, x + adj[i][0], y + adj[i][1], index + 1)){
                return true;
            }
        }
        //back tracking, unmark the path
        board[x][y] = wordChar[index];
        return false;
    }
}
