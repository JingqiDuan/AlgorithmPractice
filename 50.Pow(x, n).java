class Solution {
    public double myPow(double x, int n) {
        if(x == 1){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1; 
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1 / x;
        }
        double half = myPow(x, n /2);
        double mol = myPow(x, n % 2);
        return half * half * mol;
    }
}
