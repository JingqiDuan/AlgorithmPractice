class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
	    dp[0] = 1;
        //外层循环是遍历数组 coins 的值
        //可以确保金额之和等于 i 的硬币面额的顺序
	for(int coin : coins){
		for(int i = coin; i <= amount; i++){
            if(i >= coin){
                dp[i] += dp[i - coin];
            }
        }
	}
	return dp[amount];
    }
}
