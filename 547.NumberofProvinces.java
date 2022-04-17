class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0){
            return 0;
        }
        int cityNum = isConnected.length;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[cityNum];
        for(int i = 0; i < cityNum; i++){
            if(!visited[i]){
                queue.offer(i);
                while(!queue.isEmpty()){
                    int city = queue.poll();
                    visited[city] = true;
                    for(int j = 0; j < cityNum; j++){
                        if(isConnected[city][j] == 1 && !visited[j]){
                            queue.offer(j);
                        }
                    }
                }
            result++;
            }
        }
        return result;
    }
}
