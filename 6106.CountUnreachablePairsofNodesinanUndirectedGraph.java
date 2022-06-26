class Solution {
    public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            return (long) n * (n - 1) / 2;
        }
        ArrayList<ArrayList<Integer>> adjecency = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjecency.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjecency.get(u).add(v);
            adjecency.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        ArrayList<Integer> parts = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            if(adjecency.get(i).size() == 0){
                parts.add(1);
                visited[i] = true;
            }else{
                int size = helper(adjecency, i, visited);
                parts.add(size);
            }
        }
        long result = 0;
        for(int i = 0; i < parts.size() - 1; i++){
            for(int j = i + 1; j < parts.size(); j++){
                result += (long)parts.get(i) * (long)parts.get(j);
            }
        }
        return result;
    }
    public int helper(ArrayList<ArrayList<Integer>> adjecency, int node, boolean[] visited){
        int size = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        size++;
        visited[node] = true;
        while(!queue.isEmpty()){
            int head = queue.poll();
            for(int neighbor : adjecency.get(head)){
                if(visited[neighbor]){
                    continue;
                }
                queue.offer(neighbor);
                size++;
                visited[neighbor] = true;
            }
        }
        return size;
    }
}
