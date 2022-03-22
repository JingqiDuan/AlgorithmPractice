class Solution {
    //dp
    public int nthUglyNumber(int n) {
        if(n < 1){
            return 0;
        }
        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2){
                p2++;
            }
            if(dp[i] == dp[p3] * 3){
                p3++;
            }
            if(dp[i] == dp[p5] * 5){
                p5++;
            }
        }
        return dp[n - 1];
    }

    /*
    //heap + set
    public int nthUglyNumber(int n) {
        if(n < 1){
            return 0;
        }
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long currentUgly = 1L, newUgly;
        heap.offer(1L);
        int[] factors = new int[]{2, 3, 5};
        for(int i = 1; i <= n; i++){
            currentUgly = heap.poll();
            for(int f : factors){
                newUgly = currentUgly * f;
                if(!set.contains(newUgly)){
                    set.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int) currentUgly;
    }*/
}
