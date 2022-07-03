class Solution {
    private final int MOD = (int) 1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = i + delay; j < i + forget; j++){
                if(j <= n){
                    dp[j] += dp[i];
                    dp[j] %= MOD;
                }
            }
        } 
        int result = 0;
        for(int i = n + 1 - forget; i <= n; i++){
            result += dp[i];
            result %= MOD;
        }
        return result;
    }
}
