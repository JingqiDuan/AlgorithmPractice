class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 1){
            result.add(0);
            return result;
        }
        int[] inDegrees = new int[n];
        ArrayList<ArrayList<Integer>> adjecency = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjecency.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            inDegrees[u]++;
            inDegrees[v]++;
            adjecency.get(u).add(v);
            adjecency.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegrees[i] == 1){
                queue.offer(i);
            }
        }
        //check remain nodes in case the graph is a line
        int remainNodes = n;
        while(remainNodes > 2){
            int size = queue.size();
            remainNodes -= size;
            for(int i = 0; i < size; i++){
                int vertex = queue.poll();
                for(int neighbour : adjecency.get(vertex)){
                    if(--inDegrees[neighbour] == 1){
                        queue.offer(neighbour);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }
}
