class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        for(int i = size - 1; i >= 0; i--){
            //!!!j <= i
            for(int j = 0; j <= i; j++){
                if(i == size - 1){
                    dp[j] = triangle.get(i).get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int minPath = Integer.MAX_VALUE;
        int[][] grid = new int[depth][depth];
        grid[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < depth; i++){
            grid[i][0] = grid[i - 1][0] + triangle.get(i).get(0);
            grid[i][i] = grid[i - 1][i - 1] + triangle.get(i).get(i);
            for(int j = 1; j < triangle.get(i).size() - 1; j++){
                grid[i][j] = Math.min(grid[i - 1][j - 1], grid[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        //check last row
        for(int i = 0; i < depth; i++){
            if(grid[depth - 1][i] < minPath){
                minPath = grid[depth - 1][i];
            }
        }
        return minPath;
    }*/
}
