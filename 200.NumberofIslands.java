public class Solution {

    public class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
         int rowNum = grid.length;
         int colNum = grid[0].length;
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numberOfIsland = 0;
        for(int i = 0; i < rowNum; i ++){
            for(int j = 0; j < colNum; j ++){
                if(grid[i][j] == '1'){
                    doBfs(grid, i, j);
                    numberOfIsland ++;
                }
            }
        }
        return numberOfIsland;
    }

    private void doBfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        int[][] adjustment = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            Coordinate coor = queue.poll();
            for(int i = 0; i < 4; i ++){
                Coordinate adj = new Coordinate(
                    coor.x + adjustment[i][0],
                    coor.y + adjustment[i][1]
                );
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y] == '1') {
                    grid[adj.x][adj.y] = '0';
                    queue.offer(adj);
                }
            }
        }
    }

    private boolean inBound(Coordinate coor, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}


