class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        int result = 10;
        int prev = 9;
        for(int i = 2; i <= n; i++){
            int cur = prev * (9 - i + 2);
            result += cur;
            prev = cur;
        }
        return result;
    }
}
