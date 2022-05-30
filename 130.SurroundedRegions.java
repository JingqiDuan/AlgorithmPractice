class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board == null || board[0].length == 0 || board[0] == null){
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] adj = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < rowNum; i++){
            if(board[i][0] == 'O'){
                queue.offer(new int[]{i, 0});
            }
            if(board[i][colNum - 1] == 'O'){
                queue.offer(new int[]{i, colNum - 1});
            }
        }
        
        for(int i = 0; i < colNum; i++){
            if(board[0][i] == 'O'){
                queue.offer(new int[]{0, i});
            }
            if(board[rowNum - 1][i] == 'O'){
                queue.offer(new int[]{rowNum - 1, i});
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cor = queue.poll();
                int x = cor[0];
                int y = cor[1];
                board[x][y] = 'A';
                for(int j = 0; j < 4; j++){
                    int adjX = x + adj[j][0];
                    int adjY = y + adj[j][1];
                    if(adjX >= 0 && adjX < rowNum && adjY >= 0 && adjY < colNum && board[adjX][adjY] == 'O'){
                        queue.offer(new int[]{adjX, adjY});
                    }
                }
            }
        }
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
