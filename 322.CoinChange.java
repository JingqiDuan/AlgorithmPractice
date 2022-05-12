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


/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i] -> min conbination to amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
*/
