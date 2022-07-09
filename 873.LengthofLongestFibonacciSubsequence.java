class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(arr[i], i);
        }
        int[][] dp = new int[len + 1][len + 1];
        int result = 0;
        for(int i = 3; i <= len; i++){
            //pay attention to arr[j - 1] * 2 > arr[i - 1] to garenteen k is at left of j
            for(int j = i - 1; j >= 1 && arr[j - 1] * 2 > arr[i - 1]; j--){
                int k = map.getOrDefault(arr[i - 1] - arr[j - 1], -1);
                if(k >= 0){
                    dp[i][j] = Math.max(dp[j][k + 1] + 1, 3);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
