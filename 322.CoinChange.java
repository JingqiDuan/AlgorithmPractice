class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0){
            return 0;
        }
        boolean[] visited = new boolean[amount + 1];
        Arrays.sort(coins);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        visited[amount] = true;
        int result = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer remainNow = queue.poll();
                for(int n : coins){
                    int remainNext = remainNow - n;
                    if(remainNext == 0){
                        return result;
                    }
                    if(remainNext < 0){
                        break;
                    }
                    if(!visited[remainNext]){
                        queue.offer(remainNext);
                        visited[remainNext] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
