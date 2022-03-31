class Solution {
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }
        //dp(i, n) = G(i - 1) * G(n - 1)
        //G(n) = dp(1, n) + dp(2, n) + ... + dp(n, n)
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
