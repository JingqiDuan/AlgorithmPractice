class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long tail = 1;
        while(true){
            long tmp = n + (tail - n % tail) % tail;
            if(helper(tmp) <= target) return tmp - n;
            tail *= 10;
        }
    }

    public long helper(long n){
        long ans = 0L;
        while(n > 0){
            ans += n % 10;
            n /= 10; 
        }
        return ans;
    }
}
