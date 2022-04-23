class Solution {
    class Cor{
        int x;
        int y;
        public Cor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid == null || grid[0].length == 0 || grid[0] == null){
            return 0;
        }
        Queue<Cor> queue = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, helper(grid, queue, i, j));
                }
            }
        }
        return result;
    }
    public int helper(int[][]grid, Queue<Cor> queue, int row, int col){
        int count = 0;
        int[][] adj = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.offer(new Cor(row, col));
        while(!queue.isEmpty()){
            Cor cor = queue.poll();
            grid[cor.x][cor.y] = 0;
            count++;
            for(int i = 0; i < 4; i++){
                Cor adjCor = new Cor(cor.x + adj[i][0], cor.y + adj[i][1]);
                if(inBound(grid, adjCor) && grid[adjCor.x][adjCor.y] == 1){
                    queue.offer(adjCor);
                    grid[adjCor.x][adjCor.y] = 0;
                }
            }
        }
        return count;
    }

    public boolean inBound(int[][] grid, Cor cor){
        int rowNum = grid.length;
        int colNum = grid[0].length;
        return cor.x < rowNum && cor.x >= 0 && cor.y < colNum && cor.y >= 0;
    }
}
