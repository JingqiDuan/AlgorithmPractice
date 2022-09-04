class Solution {
    Map<String, Integer> map = new HashMap<>();
    int MOD = (int) 1e9 + 7;
    public int numberOfWays(int startPos, int endPos, int k) {
        if(k == 0){
            return startPos == endPos ? 1 : 0;
        }
        
        
        if(Math.abs(startPos - endPos) > k){
            return 0;
        }
        String str = startPos + "," + k;
        if(map.containsKey(str)){
            return map.get(str);
        }
        int result = 0;
        result += numberOfWays(startPos - 1, endPos, k - 1) % MOD;
        result += numberOfWays(startPos + 1, endPos, k - 1) % MOD;
        result %= MOD;
        map.put(str, result);
        return result;
    }
}
