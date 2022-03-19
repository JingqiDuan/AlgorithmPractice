class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            //check if it's valid int
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10){
                return 0;
            }
            //modular of a minus number is also minus
            int lastDigit = x % 10;
            result  = result * 10 + lastDigit;
            x /= 10;
        }
        return result;
    }
}
