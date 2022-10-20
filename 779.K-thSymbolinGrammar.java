class Solution {
    public int kthGrammar(int n, int k) {
        return helper(n, k, 1) == 0 ? 1 : 0;
    }
    public int helper(int n, int k, int cur){
        if(n == 1) return cur;
        if(k % 2 == 0 && cur == 0 || k % 2 == 1 && cur == 1){
            return helper(n - 1, (k - 1) / 2 + 1, 1);
        }else{
            return helper(n - 1, (k - 1) / 2 + 1, 0);
        }
    }
}
