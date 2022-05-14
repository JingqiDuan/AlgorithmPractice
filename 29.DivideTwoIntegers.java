class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            return dividend > Integer.MIN_VALUE ? -dividend : Integer.MAX_VALUE;
        }
        //Integer.MIN_VALUE -> Integer.MAX_VALUE will out or range
        long a = (long)dividend < 0 ? -(long)dividend : (long)dividend;
        long b = (long)divisor < 0 ? -(long)divisor : (long)divisor;
        boolean negative = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            negative = true;
        }
        int result = div(a, b);
        if(negative){
            return result > Integer.MIN_VALUE ? -result : Integer.MAX_VALUE;
        }
        return result;
    }
    public int div(long a, long b){
        if(a < b){
            return 0;
        }
        long add = b;
        int result = 1;
        while(add + add < a){
            add = add + add;
            result = result + result;
        }
        return result + div(a - add, b);
    }
}
