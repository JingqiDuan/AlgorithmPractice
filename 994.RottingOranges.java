class Solution {
    class Cor{
        int x;
        int y;
        public Cor(int x, int y){
            this.x = x;
            this.y = y;            
        }
    }
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue<Cor> queue = new LinkedList<>();
        int rowNum = grid.length;
        int colNum = grid[0].length;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Cor(i, j));
                }
            }
        }
        int[][] adj = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cor cor = queue.poll();                
                for(int j = 0; j < 4; j++){
                    int adjX = cor.x + adj[j][0];
                    int adjY = cor.y + adj[j][1];
                    Cor adjCor = new Cor(adjX, adjY);
                    if(inBound(grid, adjCor) && grid[adjX][adjY] == 1){
                        grid[adjX][adjY] = 2;
                        queue.offer(new Cor(adjX, adjY));
                    }
                }
            }
            //in case the rotten one didn't affact any adjecency
            if(!queue.isEmpty()){
                result++;
            }
        }

        for(int[] row : grid){
            for(int n : row){
                if(n == 1){
                    return -1;
                }
            }
        }

        return result;
    }


    public boolean inBound(int[][] grid, Cor cor){
        int row = grid.length;
        int col = grid[0].length;
        int x = cor.x;
        int y = cor.y;
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
