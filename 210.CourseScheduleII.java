class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return new int[]{};
        }

        //build indegree and adjecency
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjecency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] results = new int[numCourses];
        int index = 0;

        for(int i = 0; i < numCourses; i++){
            adjecency.add(new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adjecency.get(u).add(v);
            adjecency.get(v).add(u);
            indegree[u]++;
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        //do bfs
        while(!queue.isEmpty()){
            int pre = queue.poll();
            results[index ++] = pre;
            for(int adj : adjecency.get(pre)){
                if(--indegree[adj] == 0){
                    queue.offer(adj);
                }
            }
        }
        
        if (index != numCourses) {
            return new int[0];
        }

        return results;
    }
}
