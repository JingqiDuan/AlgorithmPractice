class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return false;
        }
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjecency = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++){
            adjecency.add(new ArrayList<Integer>());
        }
        //calculate indegree and adjecency for every course
        for(int[] couple : prerequisites){
            int pre = couple[0];
            int aft = couple[1];
            inDegree[pre] ++;
            adjecency.get(pre).add(aft);
            adjecency.get(aft).add(pre);
        }
        Queue<Integer> queue = new LinkedList<>();
        //put all independent course in queue
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        //do BFS
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses --;
            //check its neighbor
            for(int n : adjecency.get(pre)){
                if(--inDegree[n] == 0){
                    queue.offer(n);
                }
            }
        }
        return numCourses==0;
    }
}
