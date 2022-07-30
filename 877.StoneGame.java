class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] cache = new int[len][len];
        for(int i = 0; i < len; i++){
            Arrays.fill(cache[i], Integer.MIN_VALUE);
        }
        return helper(piles, 0, len - 1, cache) > 0;
    }
    public int helper(int[] piles, int left, int right, int[][] cache){
        if(left == right){
            return piles[left];
        }
        if(cache[left][right] == Integer.MIN_VALUE){
            cache[left][right] = Math.max(piles[left] - helper(piles, left + 1, right, cache),
                                            piles[right] - helper(piles, left, right - 1, cache));
        }
        return cache[left][right];
    }
}

/*
class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        return helper(piles, 0, len - 1) > 0;
    }
    public int helper(int[] piles, int left, int right){
        if(left == right){
            return piles[left];
        }
        return Math.max(piles[left] - helper(piles, left + 1, right),
                                            piles[right] - helper(piles, left, right - 1));
    }
}
*/
