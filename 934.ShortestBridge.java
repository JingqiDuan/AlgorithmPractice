class Solution {
    private Queue<int[]> queue;
    private int[][] ADJ = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] grid) {
        this.queue = new LinkedList<>();
        int n = grid.length;
        boolean visited = false;
        for(int i = 0; !visited && i < n; i++){
            for(int j = 0; !visited && j < n; j++){
                if(grid[i][j] == 1){
                    helper(grid, i, j);
                    visited = true;
                }
            }
        }
        int result = 0;
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cor = queue.poll();
                for(int[] adj : ADJ){
                    int x = cor[0] + adj[0];
                    int y = cor[1] + adj[1];
                    if(inbound(grid, x, y)){
                        if(grid[x][y] == 0){
                            queue.offer(new int[]{x, y});
                            grid[x][y] = 2;
                        }else if(grid[x][y] == 1) return result;
                    }
                }
            }
        }
        return result;
    }

    public void helper(int[][] grid, int i, int j){
        if(!inbound(grid, i, j) || grid[i][j] == 2) return;

        if(grid[i][j] == 0){
            queue.offer(new int[]{i, j});
            grid[i][j] = 2;
            return;
        }
        grid[i][j] = 2;
        for(int[] adj : ADJ) helper(grid, i + adj[0], j + adj[1]);
    }

    public boolean inbound(int[][] grid, int i, int j){
        int len = grid.length;
        return i >= 0 && i < len && j >= 0 && j < len;
    }
}
