class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for(int node : restricted){
            set.add(node);
        }
        ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();
        for(int i = 0; i < n; i++){
            neighbours.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            neighbours.get(u).add(v);
            neighbours.get(v).add(u);
        }
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        result++;
        while(!queue.isEmpty()){
            int head = queue.poll();
            for(int neighbour : neighbours.get(head)){
                if(!set.contains(neighbour)){
                    queue.offer(neighbour);
                    result++;
                }
                set.add(head);
            }
        }
        return result;
    }
}
