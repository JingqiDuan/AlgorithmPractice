class Solution {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}



/*

class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean result = false;
        for(int i = 4; i <= n; i++){
            result = !a || !b || !c;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }
}

class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for(int i = 4; i <= n; i++){
            dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3]; 
        }
        return dp[n];
    }
}

class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
    }
}
*/
