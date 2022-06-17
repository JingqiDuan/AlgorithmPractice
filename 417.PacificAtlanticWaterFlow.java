class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < n; i++){
            bfs(heights, 0, i, pacific);
        }
        for(int i = 1; i < m; i++){
            bfs(heights, i, 0, pacific);
        }
        for(int i = 0; i < m; i++){
            bfs(heights, i, n - 1, atlantic);
        }
        for(int i = 0; i < n - 1; i++){
            bfs(heights, m - 1, i, atlantic);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    results.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return results;
    }
    public void bfs(int[][] heights, int row, int col, boolean[][] ocean){
        int[] cor = new int[]{row, col};
        int[][] adj = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(cor);
      //mark once added into queue
        ocean[row][col] = true;
        while(!queue.isEmpty()){
            int[] curCor = queue.poll();
            int x = curCor[0];
            int y = curCor[1];
            for(int i = 0; i < 4; i++){
                int adjX = x + adj[i][0];
                int adjY = y + adj[i][1];
                if(adjX < 0 || adjX > heights.length - 1 || adjY < 0 || adjY > heights[0].length - 1 || ocean[adjX][adjY]){
                    continue;
                }
                if(heights[adjX][adjY] >= heights[x][y]){
                    queue.offer(new int[]{adjX, adjY});
                    ocean[adjX][adjY] = true;
                }
            }
        }
    }
}
