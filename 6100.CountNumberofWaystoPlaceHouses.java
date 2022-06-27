class Solution {
    //int MOD = 10000000007; not gonna pass. why ?
    private final int MOD = (int) 1e9 + 7;
    public int countHousePlacements(int n) {
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i = 1; i <= n; i++){
            dp[i][0] += (dp[i - 1][1] + dp[i - 1][0]) % MOD;
            dp[i][1] += dp[i - 1][0] % MOD;
        }
        long resultRoot = (dp[n][0] + dp[n][1]) % MOD;
        return (int)(resultRoot  * resultRoot % MOD);
    }
}
