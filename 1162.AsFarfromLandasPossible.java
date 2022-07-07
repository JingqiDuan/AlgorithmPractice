class Solution {
    private static final int[][] ADJ = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int result = 0; 
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                int[] cor = queue.poll();
                int x = cor[0];
                int y = cor[1];
                for(int i = 0; i < 4; i++){
                    int adjX = x + ADJ[i][0];
                    int adjY = y + ADJ[i][1];
                    if(adjX >= 0 && adjX < m && adjY >= 0 && adjY < n && grid[adjX][adjY] == 0){
                        queue.offer(new int[]{adjX, adjY});
                        grid[adjX][adjY] = 1;
                    }
                }
            }
            result++;
        }
        return result > 1 ? result - 1 : -1;
    }
}
