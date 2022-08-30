class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = helper(rowConditions, k);
        int[] col = helper(colConditions, k);
        if(row.length < k || col.length < k){
            return new int[][]{};
        }
        int[] colIndex = new int[k];
        for(int i = 0; i < k; i++){
            colIndex[col[i]] = i; 
        } 
        int[][] ans = new int[k][k];
        for(int i = 0; i < k; i++){
            ans[i][colIndex[row[i]]] = row[i] + 1;
        }
        return ans;
    }

    public int[] helper(int[][] conditions, int k){
        List<List<Integer>> adjecency = new ArrayList<>();
        int len = conditions.length;
        for(int i = 0; i < k; i++){
            adjecency.add(new ArrayList<>());
        }
        int[] indegree = new int[k];
        for(int[] arr : conditions){
            int u = arr[0] - 1;
            int v = arr[1] - 1;
            adjecency.get(u).add(v);
            //adjecency.get(v).add(u);
            indegree[v]++;
        }
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int num = queue.poll();
            order.add(num);
            for(int neighbour : adjecency.get(num)){
                if(--indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return order.stream().mapToInt(x -> x).toArray();
    }
}
