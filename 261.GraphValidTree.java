public static boolean validTree(int n, int[][] edges){
    //a valid tree has n nodes and n - 1 edges
    //while having n nodes connected to other
    if(n == 0){
        return false;
    }
    if(edges.length != n - 1){
        return false;
    }
    Map<Integer, Set<Integer>> graph = initGraph(n, edges);
    //BFS
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> hash = new HashSet<>();
    queue.offer(0);
    hash.add(0);
    while(!queue.isEmpty()){
        int node = queue.poll();
        //loop through the set
        for(Integer neighbor : graph.get(node)){
            //if the neighbor has already been checked
            if(hash.contains(neighbor)){
                continue;
            }
            hash.add(neighbor);
            queue.offer(neighbor);
        }
    }
    return hash.size() == n;
}

private static Map<Integer, Set<Integer>> initGraph(int n, int[][] edges){
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for(int i = 0; i < n; i++){
        graph.put(i, new HashSet<Integer>());
    }
    for(int i = 0; i < edges.length; i ++){
        int u = edges[i][0];
        int v = edges[i][1];
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    return graph;
}
